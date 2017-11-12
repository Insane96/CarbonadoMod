package net.insane96mcp.carbonado.lib;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialHandler {
	public static ToolMaterial Carbonado = EnumHelper.addToolMaterial("carbonado", Properties.ToolMaterial.harvestLevel, Properties.ToolMaterial.maxUses, Properties.ToolMaterial.efficency, Properties.ToolMaterial.baseDamage, Properties.ToolMaterial.enchantability);
	public static ArmorMaterial carbonadoArmorMaterial = EnumHelper.addArmorMaterial("carbonado", "carbonado:carbonado_armor", Properties.ArmorMaterial.baseDurability, Properties.ArmorMaterial.armorPoints, Properties.ArmorMaterial.enchantability, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Properties.ArmorMaterial.toughness);
}
