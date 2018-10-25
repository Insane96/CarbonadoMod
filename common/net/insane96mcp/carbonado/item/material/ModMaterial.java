package net.insane96mcp.carbonado.item.material;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterial {
	public static ToolMaterial Tools = EnumHelper.addToolMaterial("carbonado", 4, 2341, 12f, 4f, 12);
	public static ArmorMaterial Armor = EnumHelper.addArmorMaterial("carbonado", "carbonado:carbonado_armor", 50, new int[] {4, 7, 8, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3f);
}
