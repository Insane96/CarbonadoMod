package net.insane96mcp.carbonado.item;

import java.util.List;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.lib.Names;
import net.insane96mcp.carbonado.lib.Tooltips;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCarbonadoShard extends Item {
	
	public ItemCarbonadoShard(String name, CreativeTabs tab) {
		setRegistryName(name);
		setCreativeTab(tab);
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SHARD;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.format(Tooltips.Shard.base_info));
	}
}
