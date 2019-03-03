package net.insane96mcp.carbonado.item;

import net.insane96mcp.carbonado.item.material.ModMaterial;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPickaxe;

public class ItemCarbonadoPickaxe extends ItemPickaxe {
	public ItemCarbonadoPickaxe(String id) {
		super(ModMaterial.TOOLS_CARBONADO, 1, -2.8f, new Properties().group(ItemGroup.TOOLS));
		
		setRegistryName(id);
	}
}
