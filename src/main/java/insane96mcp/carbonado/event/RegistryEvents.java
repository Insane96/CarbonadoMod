package insane96mcp.carbonado.event;

import insane96mcp.carbonado.Carbonado;
import insane96mcp.carbonado.block.CarbonadoBlock;
import insane96mcp.carbonado.block.CarbonadoGlassBlock;
import insane96mcp.carbonado.block.CarbonadoGlassPaneBlock;
import insane96mcp.carbonado.block.CarbonadoOreBlock;
import insane96mcp.carbonado.item.material.ModMaterial;
import insane96mcp.carbonado.setup.ModBlocks;
import insane96mcp.carbonado.setup.Strings;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Carbonado.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

	@SubscribeEvent
	public static void onRegisterBlocks(final RegistryEvent.Register<Block> blockRegistryEvent) {
		blockRegistryEvent.getRegistry().registerAll(
				new CarbonadoOreBlock().setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_ORE),
				new CarbonadoBlock().setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_BLOCK),
				new CarbonadoGlassBlock().setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_GLASS),
				new CarbonadoGlassPaneBlock().setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_GLASS_PANE)
		);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> itemRegistryEvent) {
		itemRegistryEvent.getRegistry().registerAll(
				new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_ITEM),
				new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_SHARD),
				new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_SHARD_MOLTEN),
				new ArmorItem(ModMaterial.ARMOR_CARBONADO, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_HELMET),
				new ArmorItem(ModMaterial.ARMOR_CARBONADO, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_CHESTPLATE),
				new ArmorItem(ModMaterial.ARMOR_CARBONADO, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_LEGGINGS),
				new ArmorItem(ModMaterial.ARMOR_CARBONADO, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_BOOTS),
				new AxeItem(ModMaterial.TOOLS_CARBONADO, 6.0f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_AXE),
				new HoeItem(ModMaterial.TOOLS_CARBONADO, 1.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_HOE),
				new PickaxeItem(ModMaterial.TOOLS_CARBONADO, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_PICKAXE),
				new ShovelItem(ModMaterial.TOOLS_CARBONADO, 1.5f, -3f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_SHOVEL),
				new SwordItem(ModMaterial.TOOLS_CARBONADO, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_SWORD),
				new BlockItem(ModBlocks.carbonadoOre, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_ORE),
				new BlockItem(ModBlocks.carbonadoBlock, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_BLOCK),
				new BlockItem(ModBlocks.carbonadoGlass, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_GLASS),
				new BlockItem(ModBlocks.carbonadoGlassPane, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(Carbonado.MOD_ID, Strings.Names.CARBONADO_GLASS_PANE)
		);
	}
}
