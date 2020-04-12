package insane96mcp.carbonado.setup;

import insane96mcp.carbonado.Carbonado;
import insane96mcp.carbonado.item.material.ModMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Carbonado.MOD_ID);

	public static final RegistryObject<Item> CARBONADO = ITEMS.register(Strings.RegistryNames.CARBONADO, () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
	public static final RegistryObject<Item> CARBONADO_SHARD = ITEMS.register(Strings.RegistryNames.CARBONADO_SHARD, () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
	public static final RegistryObject<Item> MOLTEN_CARBONADO_SHARD = ITEMS.register(Strings.RegistryNames.MOLTEN_CARBONADO_SHARD, () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

	public static final RegistryObject<ArmorItem> CARBONADO_HELMET = ITEMS.register(Strings.RegistryNames.CARBONADO_HELMET, () -> new ArmorItem(ModMaterial.ARMOR_CARBONADO, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final RegistryObject<ArmorItem> CARBONADO_CHESTPLATE = ITEMS.register(Strings.RegistryNames.CARBONADO_CHESTPLATE, () -> new ArmorItem(ModMaterial.ARMOR_CARBONADO, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final RegistryObject<ArmorItem> CARBONADO_LEGGINGS = ITEMS.register(Strings.RegistryNames.CARBONADO_LEGGINGS, () -> new ArmorItem(ModMaterial.ARMOR_CARBONADO, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final RegistryObject<ArmorItem> CARBONADO_BOOTS = ITEMS.register(Strings.RegistryNames.CARBONADO_BOOTS, () -> new ArmorItem(ModMaterial.ARMOR_CARBONADO, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));

	public static final RegistryObject<PickaxeItem> CARBONADO_PICKAXE = ITEMS.register(Strings.RegistryNames.CARBONADO_PICKAXE, () -> new PickaxeItem(ModMaterial.TOOLS_CARBONADO, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final RegistryObject<AxeItem> CARBONADO_AXE = ITEMS.register(Strings.RegistryNames.CARBONADO_AXE, () -> new AxeItem(ModMaterial.TOOLS_CARBONADO, 5.0f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final RegistryObject<ShovelItem> CARBONADO_SHOVEL = ITEMS.register(Strings.RegistryNames.CARBONADO_SHOVEL, () -> new ShovelItem(ModMaterial.TOOLS_CARBONADO, 1.5f, -3f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final RegistryObject<HoeItem> CARBONADO_HOE = ITEMS.register(Strings.RegistryNames.CARBONADO_HOE, () -> new HoeItem(ModMaterial.TOOLS_CARBONADO, 1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final RegistryObject<SwordItem> CARBONADO_SWORD = ITEMS.register(Strings.RegistryNames.CARBONADO_SWORD, () -> new SwordItem(ModMaterial.TOOLS_CARBONADO, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));

	public static final RegistryObject<BlockItem> CARBONADO_BLOCK = ITEMS.register(Strings.RegistryNames.CARBONADO_BLOCK, () -> new BlockItem(ModBlocks.CARBONADO_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<BlockItem> CARBONADO_ORE = ITEMS.register(Strings.RegistryNames.CARBONADO_ORE, () -> new BlockItem(ModBlocks.CARBONADO_ORE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<BlockItem> CARBONADO_GLASS = ITEMS.register(Strings.RegistryNames.CARBONADO_GLASS, () -> new BlockItem(ModBlocks.CARBONADO_GLASS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<BlockItem> CARBONADO_GLASS_PANE = ITEMS.register(Strings.RegistryNames.CARBONADO_GLASS_PANE, () -> new BlockItem(ModBlocks.CARBONADO_GLASS_PANE.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
}
