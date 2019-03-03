package net.insane96mcp.carbonado.init;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.init.Strings.Names;
import net.insane96mcp.carbonado.item.ItemCarbonado;
import net.insane96mcp.carbonado.item.ItemCarbonadoArmor;
import net.insane96mcp.carbonado.item.ItemCarbonadoAxe;
import net.insane96mcp.carbonado.item.ItemCarbonadoPickaxe;
import net.insane96mcp.carbonado.item.ItemCarbonadoShovel;
import net.insane96mcp.carbonado.item.ItemCarbonadoSword;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_ITEM)
	public static ItemCarbonado carbonado;
	
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SHARD)
	public static Item carbonadoShard;
	
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SHARD_MOLTEN)
	public static Item carbonadoShardMolten;
	
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_PICKAXE)
	public static ItemCarbonadoPickaxe carbonadoPickaxe;
	
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SHOVEL)
	public static ItemCarbonadoShovel carbonadoShovel;
	
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_AXE)
	public static ItemCarbonadoAxe carbonadoAxe;
	
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_HOE)
	public static ItemHoe carbonadoHoe;
	
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SWORD)
	public static ItemCarbonadoSword carbonadoSword;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_HELMET)
	public static ItemCarbonadoArmor carbonadoHelmet;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_CHESTPLATE)
	public static ItemCarbonadoArmor carbonadoChestplate;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_LEGGINGS)
	public static ItemCarbonadoArmor carbonadoLeggings;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_BOOTS)
	public static ItemCarbonadoArmor carbonadoBoots;
	
	//TODO
	/*
	public static void PostInit() {
		GameRegistry.addSmelting(new ItemStack(carbonadoShardItem), new ItemStack(carbonadoShardMoltenItem), 3.0f);
		
		OreDictionary.registerOre("gemCarbonado", carbonadoItem);
	}*/
}
