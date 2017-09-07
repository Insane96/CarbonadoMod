package net.insane96mcp.carbonado.lib;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialHandler {
	public static ToolMaterial Carbonado = EnumHelper.addToolMaterial("carbonado", Stats.ToolMaterial.harvestLevel, Stats.ToolMaterial.maxUses, Stats.ToolMaterial.efficency, Stats.ToolMaterial.baseDamage, Stats.ToolMaterial.enchantability);
	public static ArmorMaterial carbonadoArmorMaterial = EnumHelper.addArmorMaterial("carbonado", "carbonado:carbonado_armor", Stats.ArmorMaterial.baseDurability, Stats.ArmorMaterial.armorPoints, Stats.ArmorMaterial.enchantability, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Stats.ArmorMaterial.toughness);
}
