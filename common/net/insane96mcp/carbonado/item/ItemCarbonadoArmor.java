package net.insane96mcp.carbonado.item;

import net.insane96mcp.carbonado.item.material.ModMaterial;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemGroup;

public class ItemCarbonadoArmor extends ItemArmor{

	public ItemCarbonadoArmor(EntityEquipmentSlot slots, String id) {
		super(ModMaterial.ARMOR_CARBONADO, slots, new Properties().group(ItemGroup.COMBAT));

		setRegistryName(id);
	}
}
