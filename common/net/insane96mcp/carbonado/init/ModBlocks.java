package net.insane96mcp.carbonado.init;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.block.BlockCarbonado;
import net.insane96mcp.carbonado.block.BlockCarbonadoGlass;
import net.insane96mcp.carbonado.block.BlockCarbonadoOre;
import net.insane96mcp.carbonado.init.Strings.Names;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
	
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_BLOCK)
	public static BlockCarbonado carbonadoBlock;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_ORE)
	public static BlockCarbonadoOre carbonadoOre;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_GLASS)
	public static BlockCarbonadoGlass carbonadoGlass;
	
	/*ResourceLocation location = new ResourceLocation(Carbonado.MOD_ID, Names.CARBONADO_BLOCK);
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
	}*/
}
