package net.insane96mcp.carbonado.init;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.block.BlockCarbonado;
import net.insane96mcp.carbonado.block.BlockCarbonadoOre;
import net.insane96mcp.carbonado.lib.Names;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.tools.nsc.doc.model.Public;
import scala.xml.dtd.PublicID;

public class ModBlocks {
	
	public static BlockCarbonado carbonadoBlock;
	public static BlockCarbonadoOre carbonadoOre;
	public static void Init() {
		ResourceLocation location = new ResourceLocation(Carbonado.MOD_ID, Names.CARBONADO_BLOCK);
		carbonadoBlock = new BlockCarbonado();
		carbonadoBlock.setRegistryName(location);
		carbonadoBlock.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		carbonadoBlock.setHardness(15.0f);
		carbonadoBlock.setResistance(10.0f);
		carbonadoBlock.setHarvestLevel("pickaxe", 3);
		GameRegistry.register(carbonadoBlock);
		GameRegistry.register(new ItemBlock(carbonadoBlock), location);

		location = new ResourceLocation(Carbonado.MOD_ID, Names.CARBONADO_ORE);
		carbonadoOre = new BlockCarbonadoOre();
		carbonadoOre.setRegistryName(location);
		carbonadoOre.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		carbonadoOre.setHardness(10.0f);
		carbonadoOre.setResistance(33.3f);
		carbonadoOre.setHarvestLevel("pickaxe", 3);
		GameRegistry.register(carbonadoOre);
		GameRegistry.register(new ItemBlock(carbonadoOre), location);
		GameRegistry.registerWorldGenerator(new GenOres(), 0);
	}
	
	public static void PostInit() {

		GameRegistry.addRecipe(new ItemStack(carbonadoBlock, 1), "xxx", "xxx", "xxx", 'x', ModItems.carbonadoItem);
	}
	
	@SideOnly(Side.CLIENT)
	public static void InitClient(ItemModelMesher mesher) {
		Item item = Item.getItemFromBlock(carbonadoBlock);
		ModelResourceLocation model = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_BLOCK);
		ModelLoader.registerItemVariants(item, model);
		mesher.register(item, 0, model);
		
		item = Item.getItemFromBlock(carbonadoOre);
		model = new ModelResourceLocation(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_ORE);
		ModelLoader.registerItemVariants(item, model);
		mesher.register(item, 0, model);
	}
}
