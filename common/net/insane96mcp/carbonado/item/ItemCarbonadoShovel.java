package net.insane96mcp.carbonado.item;

import net.insane96mcp.carbonado.item.material.ModMaterial;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSpade;

public class ItemCarbonadoShovel extends ItemSpade{
	public ItemCarbonadoShovel(String id) {
		super(ModMaterial.TOOLS_CARBONADO, 1.5f, -3f, new Properties().group(ItemGroup.TOOLS));
		
		setRegistryName(id);
	}
}
