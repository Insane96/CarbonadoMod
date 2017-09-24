package net.insane96mcp.carbonado.lib;

import net.insane96mcp.carbonado.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IWorldEventListener;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CustomEventHandler {
	@SubscribeEvent
	public static void LivingHurtEvent(LivingHurtEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		
		if (!(entity instanceof EntityPlayer)) 
			return;
		
		EntityPlayer player = (EntityPlayer)entity;
		DamageSource source = event.getSource();
				
		ItemStack[] armorList = new ItemStack[] {
			new ItemStack(ModItems.carbonadoHelmetItem), 
			new ItemStack(ModItems.carbonadoChestplateItem), 
			new ItemStack(ModItems.carbonadoLeggingsItem), 
			new ItemStack(ModItems.carbonadoBootsItem)
		};
		
		float[] materialPerPiece = new float[] { 5, 8, 7, 4 };
		
	    int materialsUsed = 0;
	    Iterable<ItemStack> playerArmor = player.getArmorInventoryList();
	    for (ItemStack armorPiece : playerArmor) {
	    	for (int i = 0; i < armorList.length; i++) {
		        if (ItemStack.areItemsEqualIgnoreDurability(armorPiece, armorList[i])) {
					materialsUsed += materialPerPiece[i];
					break;
				}
			}
		}
	    
		float amount = event.getAmount();
	    
	    if(materialsUsed >= 1) {
	    	float maxReduction = Stats.ArmorMaterial.armorDamageReduction / 100;
	    	float reductionPerMaterial = maxReduction / 24f;
	    	float percentageReduction = reductionPerMaterial * materialsUsed;
	    	amount = amount * (1f - percentageReduction);
	        event.setAmount(amount);
	    }
	}
	
	@SubscribeEvent
	public static void EntityJoinWorldEvent(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
	
		if (!(entity instanceof EntityWitherSkeleton)) 
			return;
		
		NBTTagCompound tags = entity.getEntityData();
		byte isAlreadyChecked = tags.getByte("carbonado:witherSkeletonSwordCheck");
		
		if (isAlreadyChecked == 1)
			return;
		
		EntityWitherSkeleton witherSkeleton = (EntityWitherSkeleton)entity;

		isAlreadyChecked = 1;
		tags.setByte("carbonado:witherSkeletonSwordCheck", isAlreadyChecked);
		
		if (event.getWorld().rand.nextFloat() < Stats.carbonadoSwordChance / 100f) {
			witherSkeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModItems.carbonadoSwordItem, 1));
			witherSkeleton.setLeftHanded(true);
		}
	}
	
	 @SubscribeEvent
	 public static void WorldEventLoad(WorldEvent.Load event) {
		 IWorldEventListener WorldEventListener = new WorldEventListener();
		 event.getWorld().addEventListener(WorldEventListener);
	 }
}
