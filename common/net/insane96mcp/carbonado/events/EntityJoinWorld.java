package net.insane96mcp.carbonado.events;

import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.lib.Properties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.SkeletonType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.sys.Prop;

public class EntityJoinWorld {
	@SubscribeEvent
	public static void EntityJoinWorldEvent(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
	
		if (!(entity instanceof EntitySkeleton)) 
			return;	
		
		NBTTagCompound tags = entity.getEntityData();
		byte isAlreadyChecked = tags.getByte("carbonado:witherSkeletonSwordCheck");
		
		if (isAlreadyChecked == 1)
			return;
		
		EntitySkeleton witherSkeleton = (EntitySkeleton)entity;
		if (witherSkeleton.getSkeletonType() != SkeletonType.WITHER)
			return;

		isAlreadyChecked = 1;
		tags.setByte("carbonado:witherSkeletonSwordCheck", isAlreadyChecked);

		if (Properties.General.swordChanceDifficultyBased) {
			float difficulty = event.getWorld().getDifficulty().getDifficultyId() / 2;
			float chance = Properties.General.carbonadoSwordChance * difficulty;
		}
		
		if (event.getWorld().rand.nextFloat() < Properties.General.carbonadoSwordChance / 100f) {
			witherSkeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModItems.carbonadoSwordItem, 1));
			witherSkeleton.setLeftHanded(true);
		}
	}
}
