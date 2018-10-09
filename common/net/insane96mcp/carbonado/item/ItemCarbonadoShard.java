package net.insane96mcp.carbonado.item;

import java.util.List;

import javax.annotation.Nullable;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.lib.Names;
import net.insane96mcp.carbonado.lib.Tooltips;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCarbonadoShard extends Item {
	
	public ItemCarbonadoShard(String name, CreativeTabs tab) {
		setRegistryName(name);
		setCreativeTab(tab);
		
	}
	
	@Override
	public String getTranslationKey(ItemStack stack) {
		return "item." + Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SHARD;
	}
}
