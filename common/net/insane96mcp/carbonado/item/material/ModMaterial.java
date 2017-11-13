package net.insane96mcp.carbonado.item.material;

import net.insane96mcp.carbonado.lib.Properties;
import net.insane96mcp.carbonado.lib.Properties.Armor;
import net.insane96mcp.carbonado.lib.Properties.Tool;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterial {
	public static ToolMaterial Tools = EnumHelper.addToolMaterial("carbonado", Properties.Tool.harvestLevel, Properties.Tool.maxUses, Properties.Tool.efficency, Properties.Tool.baseDamage, Properties.Tool.enchantability);
	public static ArmorMaterial Armor = EnumHelper.addArmorMaterial("carbonado", "carbonado:carbonado_armor", Properties.Armor.baseDurability, Properties.Armor.armorPoints, Properties.Armor.enchantability, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Properties.Armor.toughness);
}
