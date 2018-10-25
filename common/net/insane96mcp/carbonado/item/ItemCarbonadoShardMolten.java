package net.insane96mcp.carbonado.item;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.lib.Strings.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCarbonadoShardMolten extends Item {
	
	public ItemCarbonadoShardMolten(String name, CreativeTabs tab) {
		setRegistryName(name);
		setCreativeTab(tab);
		
	}
	
	@Override
	public String getTranslationKey(ItemStack stack) {
		return "item." + Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SHARD_MOLTEN;
	}
}
