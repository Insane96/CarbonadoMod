package net.insane96mcp.carbonado.init;

import java.util.ArrayList;

import net.insane96mcp.carbonado.item.ItemCarbonado;
import net.insane96mcp.carbonado.item.ItemCarbonadoArmor;
import net.insane96mcp.carbonado.item.ItemCarbonadoAxe;
import net.insane96mcp.carbonado.item.ItemCarbonadoHoe;
import net.insane96mcp.carbonado.item.ItemCarbonadoPickaxe;
import net.insane96mcp.carbonado.item.ItemCarbonadoShard;
import net.insane96mcp.carbonado.item.ItemCarbonadoShardMolten;
import net.insane96mcp.carbonado.item.ItemCarbonadoShovel;
import net.insane96mcp.carbonado.item.ItemCarbonadoSword;
import net.insane96mcp.carbonado.item.material.ModMaterial;
import net.insane96mcp.carbonado.lib.Strings.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
	
	public static ItemCarbonado carbonadoItem;
	public static ItemCarbonadoShard carbonadoShardItem;
	public static ItemCarbonadoShardMolten carbonadoShardMoltenItem;
	
	public static ItemCarbonadoPickaxe carbonadoPickaxeItem;
	public static ItemCarbonadoShovel carbonadoShovelItem;
	public static ItemCarbonadoAxe carbonadoAxeItem;
	public static ItemCarbonadoHoe carbonadoHoeItem;
	public static ItemCarbonadoSword carbonadoSwordItem;

	public static ItemCarbonadoArmor carbonadoHelmetItem;
	public static ItemCarbonadoArmor carbonadoChestplateItem;
	public static ItemCarbonadoArmor carbonadoLeggingsItem;
	public static ItemCarbonadoArmor carbonadoBootsItem;
	
	public static ArrayList<Item> ITEMS = new ArrayList<Item>();
	
	public static void Init() {
		carbonadoItem = new ItemCarbonado(Names.CARBONADO_ITEM, CreativeTabs.MATERIALS);
		ITEMS.add(carbonadoItem);

		carbonadoShardItem = new ItemCarbonadoShard(Names.CARBONADO_SHARD, CreativeTabs.MISC);
		ITEMS.add(carbonadoShardItem);

		carbonadoShardMoltenItem = new ItemCarbonadoShardMolten(Names.CARBONADO_SHARD_MOLTEN, CreativeTabs.MISC);
		ITEMS.add(carbonadoShardMoltenItem);

		carbonadoPickaxeItem = new ItemCarbonadoPickaxe(Names.CARBONADO_PICKAXE, ModMaterial.Tools, CreativeTabs.TOOLS);
		ITEMS.add(carbonadoPickaxeItem);

		carbonadoShovelItem = new ItemCarbonadoShovel(Names.CARBONADO_SHOVEL, ModMaterial.Tools, CreativeTabs.TOOLS);
		ITEMS.add(carbonadoShovelItem);

		carbonadoAxeItem = new ItemCarbonadoAxe(Names.CARBONADO_AXE, ModMaterial.Tools, CreativeTabs.TOOLS);
		ITEMS.add(carbonadoAxeItem);
		
		carbonadoHoeItem = new ItemCarbonadoHoe(Names.CARBONADO_HOE, ModMaterial.Tools, CreativeTabs.TOOLS);
		ITEMS.add(carbonadoHoeItem);
		
		carbonadoSwordItem = new ItemCarbonadoSword(Names.CARBONADO_SWORD, ModMaterial.Tools, CreativeTabs.COMBAT);
		ITEMS.add(carbonadoSwordItem);

		carbonadoHelmetItem = new ItemCarbonadoArmor(Names.CARBONADO_HELMET, ModMaterial.Armor, 0, EntityEquipmentSlot.HEAD);
		ITEMS.add(carbonadoHelmetItem);

		carbonadoChestplateItem = new ItemCarbonadoArmor(Names.CARBONADO_CHESTPLATE, ModMaterial.Armor, 0, EntityEquipmentSlot.CHEST);
		ITEMS.add(carbonadoChestplateItem);

		carbonadoLeggingsItem = new ItemCarbonadoArmor(Names.CARBONADO_LEGGINGS, ModMaterial.Armor, 1, EntityEquipmentSlot.LEGS);
		ITEMS.add(carbonadoLeggingsItem);

		carbonadoBootsItem = new ItemCarbonadoArmor(Names.CARBONADO_BOOTS, ModMaterial.Armor, 0, EntityEquipmentSlot.FEET);
		ITEMS.add(carbonadoBootsItem);
	}
	
	public static void PostInit() {
		GameRegistry.addSmelting(new ItemStack(carbonadoShardItem), new ItemStack(carbonadoShardMoltenItem), 3.0f);
		
		OreDictionary.registerOre("gemCarbonado", carbonadoItem);
	}
}
