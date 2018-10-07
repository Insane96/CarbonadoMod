package net.insane96mcp.carbonado.item;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.lib.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemCarbonadoPickaxe extends ItemPickaxe {
	public ItemCarbonadoPickaxe(String name, ToolMaterial material, CreativeTabs tab) {
		super(material);
		setRegistryName(name);
		setCreativeTab(tab);
	}

	@Override
	public String getTranslationKey(ItemStack stack) {
		return "item." + Carbonado.RESOURCE_PREFIX + Names.CARBONADO_PICKAXE;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return ItemStack.areItemsEqualIgnoreDurability(repair, new ItemStack(ModItems.carbonadoItem)) ? true : super.getIsRepairable(toRepair, repair);
  	}
}
