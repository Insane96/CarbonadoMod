package net.insane96mcp.carbonado.init;

import net.insane96mcp.carbonado.Carbonado;
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
import net.insane96mcp.carbonado.lib.Names;
import net.insane96mcp.carbonado.lib.Properties;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
	
	public static void Init() {
		carbonadoItem = new ItemCarbonado(Names.CARBONADO_ITEM, CreativeTabs.MATERIALS);
		GameRegistry.register(carbonadoItem);

		carbonadoShardItem = new ItemCarbonadoShard(Names.CARBONADO_SHARD, CreativeTabs.MISC);
		GameRegistry.register(carbonadoShardItem);

		carbonadoShardMoltenItem = new ItemCarbonadoShardMolten(Names.CARBONADO_SHARD_MOLTEN, CreativeTabs.MISC);
		GameRegistry.register(carbonadoShardMoltenItem);

		carbonadoPickaxeItem = new ItemCarbonadoPickaxe(Names.CARBONADO_PICKAXE, ModMaterial.Tools, CreativeTabs.TOOLS);
		GameRegistry.register(carbonadoPickaxeItem);

		carbonadoShovelItem = new ItemCarbonadoShovel(Names.CARBONADO_SHOVEL, ModMaterial.Tools, CreativeTabs.TOOLS);
		GameRegistry.register(carbonadoShovelItem);

		carbonadoAxeItem = new ItemCarbonadoAxe(Names.CARBONADO_AXE, ModMaterial.Tools, CreativeTabs.TOOLS);
		GameRegistry.register(carbonadoAxeItem);
		
		carbonadoHoeItem = new ItemCarbonadoHoe(Names.CARBONADO_HOE, ModMaterial.Tools, CreativeTabs.TOOLS);
		GameRegistry.register(carbonadoHoeItem);
		
		carbonadoSwordItem = new ItemCarbonadoSword(Names.CARBONADO_SWORD, ModMaterial.Tools, CreativeTabs.COMBAT);
		GameRegistry.register(carbonadoSwordItem);

		carbonadoHelmetItem = new ItemCarbonadoArmor(Names.CARBONADO_HELMET, ModMaterial.Armor, 0, EntityEquipmentSlot.HEAD);
		GameRegistry.register(carbonadoHelmetItem);

		carbonadoChestplateItem = new ItemCarbonadoArmor(Names.CARBONADO_CHESTPLATE, ModMaterial.Armor, 0, EntityEquipmentSlot.CHEST);
		GameRegistry.register(carbonadoChestplateItem);

		carbonadoLeggingsItem = new ItemCarbonadoArmor(Names.CARBONADO_LEGGINGS, ModMaterial.Armor, 1, EntityEquipmentSlot.LEGS);
		GameRegistry.register(carbonadoLeggingsItem);

		carbonadoBootsItem = new ItemCarbonadoArmor(Names.CARBONADO_BOOTS, ModMaterial.Armor, 0, EntityEquipmentSlot.FEET);
		GameRegistry.register(carbonadoBootsItem);
	}
	
	public static void PostInit() {
		GameRegistry.addShapelessRecipe(new ItemStack(carbonadoItem, 9), ModBlocks.carbonadoBlock);
		
		GameRegistry.addSmelting(new ItemStack(carbonadoShardItem), new ItemStack(carbonadoShardMoltenItem), 3.0f);

		GameRegistry.addRecipe(new ItemStack(carbonadoPickaxeItem), "vvv", " s ", " s ", 'v', carbonadoItem, 's', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(carbonadoShovelItem), "v", "s", "s", 'v', carbonadoItem, 's', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(carbonadoAxeItem), "vv", "sv", "s ", 'v', carbonadoItem, 's', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(carbonadoHoeItem), "vv", "s ", "s ", 'v', carbonadoItem, 's', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(carbonadoSwordItem), "v", "v", "s", 'v', carbonadoItem, 's', Items.STICK);

		GameRegistry.addRecipe(new ItemStack(carbonadoHelmetItem), "vvv", "v v", 'v', carbonadoItem);
		GameRegistry.addRecipe(new ItemStack(carbonadoChestplateItem), "v v", "vvv", "vvv", 'v', carbonadoItem);
		GameRegistry.addRecipe(new ItemStack(carbonadoLeggingsItem), "vvv", "v v", "v v", 'v', carbonadoItem);
		GameRegistry.addRecipe(new ItemStack(carbonadoBootsItem), "v v", "v v", 'v', carbonadoItem);
	}
	
	@SideOnly(Side.CLIENT)
	public static void InitClient(ItemModelMesher mesher) {
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_ITEM);
		ModelLoader.registerItemVariants(carbonadoItem, modelResourceLocation);
		mesher.register(carbonadoItem, 0, modelResourceLocation);

		modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SHARD);
		ModelLoader.registerItemVariants(carbonadoShardItem, modelResourceLocation);
		mesher.register(carbonadoShardItem, 0, modelResourceLocation);

		if (Properties.Shards.oldMoltenShardTexture)
			modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SHARD_MOLTEN_OLD);
		else
			modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SHARD_MOLTEN);
		ModelLoader.registerItemVariants(carbonadoShardMoltenItem, modelResourceLocation);
		mesher.register(carbonadoShardMoltenItem, 0, modelResourceLocation);
		
		
		modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_PICKAXE);
		ModelLoader.registerItemVariants(carbonadoPickaxeItem, modelResourceLocation);
		mesher.register(carbonadoPickaxeItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SHOVEL);
		ModelLoader.registerItemVariants(carbonadoShovelItem, modelResourceLocation);
		mesher.register(carbonadoShovelItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_AXE);
		ModelLoader.registerItemVariants(carbonadoAxeItem, modelResourceLocation);
		mesher.register(carbonadoAxeItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_HOE);
		ModelLoader.registerItemVariants(carbonadoHoeItem, modelResourceLocation);
		mesher.register(carbonadoHoeItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_SWORD);
		ModelLoader.registerItemVariants(carbonadoSwordItem, modelResourceLocation);
		mesher.register(carbonadoSwordItem, 0, modelResourceLocation);

		
		modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_HELMET);
		ModelLoader.registerItemVariants(carbonadoHelmetItem, modelResourceLocation);
		mesher.register(carbonadoHelmetItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_CHESTPLATE);
		ModelLoader.registerItemVariants(carbonadoChestplateItem, modelResourceLocation);
		mesher.register(carbonadoChestplateItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_LEGGINGS);
		ModelLoader.registerItemVariants(carbonadoLeggingsItem, modelResourceLocation);
		mesher.register(carbonadoLeggingsItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_BOOTS);
		ModelLoader.registerItemVariants(carbonadoBootsItem, modelResourceLocation);
		mesher.register(carbonadoBootsItem, 0, modelResourceLocation);
	}
}
