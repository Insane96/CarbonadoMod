package net.insane96mcp.carbonado.item;

import net.insane96mcp.carbonado.item.material.ModMaterial;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSword;

public class ItemCarbonadoSword extends ItemSword{
	public ItemCarbonadoSword(String id) {
		super(ModMaterial.TOOLS_CARBONADO, 3, -2.4f, new Properties().group(ItemGroup.COMBAT));

		setRegistryName(id);
	}
}
