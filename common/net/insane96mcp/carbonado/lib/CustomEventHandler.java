package net.insane96mcp.carbonado.lib;

import net.insane96mcp.carbonado.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IWorldEventListener;
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
	    	float maxReduction = Stats.armorDamageReduction / 100;
	    	float reductionPerMaterial = maxReduction / 24f;
	    	float percentageReduction = reductionPerMaterial * materialsUsed;
	    	amount = amount * (1f - percentageReduction);
	        event.setAmount(amount);
	    }
	}
	
	/*@SubscribeEvent
	public static void LivingSpawnEvent(LivingSpawnEvent.CheckSpawn event) {
		Entity entity = event.getEntity();
		if (entity instanceof EntityWitherSkeleton) {
			int rand = event.getWorld().rand.nextInt(100);
			if (rand < Stats.carbonadoSwordChance) {
				entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_AXE, 1));
				((EntityWitherSkeleton)entity).setLeftHanded(true);
			}
		}
	}*/
	
	 @SubscribeEvent
	 public static void WorldEventLoad(WorldEvent.Load event) {
		 IWorldEventListener WorldEventListener = new WorldEventListener();
		 event.getWorld().addEventListener(WorldEventListener);
	 }
}
