package net.insane96mcp.carbonado.lib;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialHandler {
	public static ToolMaterial Carbonado = EnumHelper.addToolMaterial("carbonado", 4, 2343, 9f, 4f, 13);
	public static ArmorMaterial carbonadoArmorMaterial = EnumHelper.addArmorMaterial("carbonado", "carbonado:carbonado_armor", 50, new int[]{3, 8, 6, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3f);
}
