package net.insane96mcp.carbonado.item;

import java.util.List;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemCarbonadoArmor extends ItemArmor{

	private final String name;
	
	public ItemCarbonadoArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.name = name;
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + Carbonado.RESOURCE_PREFIX + this.name;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return ItemStack.areItemsEqualIgnoreDurability(repair, new ItemStack(ModItems.carbonadoItem)) ? true : super.getIsRepairable(toRepair, repair);
  	}
}
