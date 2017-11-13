package net.insane96mcp.carbonado.events;

import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.lib.Properties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityJoinWorld {
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

		float chance = Properties.General.carbonadoSwordChance / 100f;
		if (Properties.General.swordChanceDifficultyBased) {
			float difficulty = event.getWorld().getDifficulty().getDifficultyId() / 2;
			chance *= difficulty;
		}
		
		if (event.getWorld().rand.nextFloat() < chance) {
			witherSkeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModItems.carbonadoSwordItem, 1));
			witherSkeleton.setLeftHanded(true);
		}
	}
}
