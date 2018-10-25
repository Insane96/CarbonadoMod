package net.insane96mcp.carbonado.init;

import java.util.ArrayList;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.block.BlockCarbonado;
import net.insane96mcp.carbonado.block.BlockCarbonadoGlass;
import net.insane96mcp.carbonado.block.BlockCarbonadoOre;
import net.insane96mcp.carbonado.lib.Strings.Names;
import net.insane96mcp.carbonado.worldgen.OreGenerator;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {
	
	public static BlockCarbonado carbonadoBlock;
	public static BlockCarbonadoOre carbonadoOre;
	public static BlockCarbonadoGlass carbonadoGlass;
	
	public static ArrayList<Block> BLOCKS = new ArrayList<Block>();
	
	public static void Init() {
		ResourceLocation location = new ResourceLocation(Carbonado.MOD_ID, Names.CARBONADO_BLOCK);
		carbonadoBlock = new BlockCarbonado();
		carbonadoBlock.setRegistryName(location);
		carbonadoBlock.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		carbonadoBlock.setHardness(15.0f);
		carbonadoBlock.setResistance(15.0f);
		carbonadoBlock.setHarvestLevel("pickaxe", 3);
		BLOCKS.add(carbonadoBlock);

		location = new ResourceLocation(Carbonado.MOD_ID, Names.CARBONADO_ORE);
		carbonadoOre = new BlockCarbonadoOre();
		carbonadoOre.setRegistryName(location);
		carbonadoOre.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		carbonadoOre.setHardness(15.0f);
		carbonadoOre.setResistance(33.3f);
		carbonadoOre.setHarvestLevel("pickaxe", 3);
		BLOCKS.add(carbonadoOre);
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);

		location = new ResourceLocation(Carbonado.MOD_ID, Names.CARBONADO_GLASS);
		carbonadoGlass = new BlockCarbonadoGlass();
		carbonadoGlass.setRegistryName(location);
		carbonadoGlass.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		BLOCKS.add(carbonadoGlass);
	}
	
	public static void PostInit() {
		OreDictionary.registerOre("oreCarbonado", carbonadoOre);
		OreDictionary.registerOre("blockCarbonado", carbonadoBlock);
	}
}
