package net.insane96mcp.carbonado.item;

import net.insane96mcp.carbonado.item.material.ModMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemGroup;

public class ItemCarbonadoAxe extends ItemAxe{
	public ItemCarbonadoAxe(String id) {
		super(ModMaterial.TOOLS_CARBONADO, 10f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS));
		
		setRegistryName(id);
	}
}
