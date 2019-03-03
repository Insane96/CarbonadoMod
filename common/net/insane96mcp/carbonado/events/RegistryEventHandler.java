package net.insane96mcp.carbonado.events;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.block.BlockCarbonado;
import net.insane96mcp.carbonado.block.BlockCarbonadoGlass;
import net.insane96mcp.carbonado.block.BlockCarbonadoOre;
import net.insane96mcp.carbonado.init.ModBlocks;
import net.insane96mcp.carbonado.init.Strings.Names;
import net.insane96mcp.carbonado.item.ItemCarbonado;
import net.insane96mcp.carbonado.item.ItemCarbonadoArmor;
import net.insane96mcp.carbonado.item.ItemCarbonadoAxe;
import net.insane96mcp.carbonado.item.ItemCarbonadoPickaxe;
import net.insane96mcp.carbonado.item.ItemCarbonadoShovel;
import net.insane96mcp.carbonado.item.ItemCarbonadoSword;
import net.insane96mcp.carbonado.item.material.ModMaterial;
import net.minecraft.block.Block;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Carbonado.MOD_ID, bus = Bus.MOD)
public class RegistryEventHandler {

    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        blockRegistryEvent.getRegistry().registerAll(
        	new BlockCarbonado(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_BLOCK),
        	new BlockCarbonadoGlass(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_GLASS),
        	new BlockCarbonadoOre(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_ORE)
        );
    }
    
    @SubscribeEvent
    public static void OnItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
    	
    	itemRegistryEvent.getRegistry().registerAll(
    		new ItemCarbonado(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_ITEM),
    		new Item(new Properties().group(ItemGroup.MATERIALS)).setRegistryName(Carbonado.MOD_ID, Names.CARBONADO_SHARD),
    		new Item(new Properties().group(ItemGroup.MATERIALS)).setRegistryName(Carbonado.MOD_ID, Names.CARBONADO_SHARD_MOLTEN),

    		new ItemCarbonadoArmor(EntityEquipmentSlot.HEAD, Carbonado.RESOURCE_PREFIX + Names.CARBONADO_HELMET),
    		new ItemCarbonadoArmor(EntityEquipmentSlot.CHEST, Carbonado.RESOURCE_PREFIX + Names.CARBONADO_CHESTPLATE),
    		new ItemCarbonadoArmor(EntityEquipmentSlot.LEGS, Carbonado.RESOURCE_PREFIX + Names.CARBONADO_LEGGINGS),
    		new ItemCarbonadoArmor(EntityEquipmentSlot.FEET, Carbonado.RESOURCE_PREFIX + Names.CARBONADO_BOOTS),
    		
    		new ItemCarbonadoAxe(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_AXE),
    		new ItemHoe(ModMaterial.TOOLS_CARBONADO, 1.0f, new Properties().group(ItemGroup.TOOLS)).setRegistryName(Carbonado.MOD_ID, Names.CARBONADO_HOE),
    		new ItemCarbonadoPickaxe(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_PICKAXE),
    		new ItemCarbonadoShovel(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SHOVEL),
    		new ItemCarbonadoSword(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SWORD),

    		new ItemBlock(ModBlocks.carbonadoBlock, new Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_BLOCK),
    		new ItemBlock(ModBlocks.carbonadoGlass, new Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_GLASS),
    		new ItemBlock(ModBlocks.carbonadoOre, new Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_ORE)
    	);
    }
}
