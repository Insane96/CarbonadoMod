package net.insane96mcp.carbonado.item;

import net.insane96mcp.carbonado.Carbonado;
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
		return "item." + Carbonado.RESOURCE_PREFIX + net.insane96mcp.carbonado.lib.Names.CARBONADO_AXE;
	}
}
