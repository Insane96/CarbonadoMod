package net.insane96mcp.carbonado.item;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.lib.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemCarbonadoAxe extends ItemAxe{
	public ItemCarbonadoAxe(String name, ToolMaterial material, CreativeTabs tab) {
		super(material, 10f, -3.0f);
		setRegistryName(name);
		setCreativeTab(tab);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + Carbonado.RESOURCE_PREFIX + Names.CARBONADO_AXE;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return ItemStack.areItemsEqualIgnoreDurability(repair, new ItemStack(ModItems.carbonadoItem)) ? true : super.getIsRepairable(toRepair, repair);
  	}
}
