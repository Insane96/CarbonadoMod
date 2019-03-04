package net.insane96mcp.carbonado.worldgen;

import java.util.function.Predicate;

import net.insane96mcp.carbonado.init.ModBlocks;
import net.insane96mcp.carbonado.init.ModConfig;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGenerator {
	private static final Predicate<IBlockState> IS_BEDROCK = state -> state.getBlock() == Blocks.BEDROCK;
	
	public static void Init() {
//TODO rewrite custom generator
		CountRangeConfig placementConfigNetherTop = new CountRangeConfig(ModConfig.OreGeneration.orePerChunkNether.get(), 123, 123, 128);
		CountRangeConfig placementConfigNetherBottom = new CountRangeConfig(ModConfig.OreGeneration.orePerChunkNether.get(), 0, 0, 5);
		CountRangeConfig placementConfigOverworld = new CountRangeConfig(ModConfig.OreGeneration.orePerChunkNether.get(), 0, 0, 5);
		
		for (Biome biome : ForgeRegistries.BIOMES) {
			//Nether
			if (biome.getCategory().equals(Category.NETHER)) {
				biome.addFeature(
					Decoration.UNDERGROUND_ORES, 
					Biome.createCompositeFeature(
						Feature.MINABLE, 
						new MinableConfig(IS_BEDROCK, ModBlocks.carbonadoOre.getDefaultState(), 3), 
						new CountRange(), 
						placementConfigNetherTop
					)
				);
				biome.addFeature(
					Decoration.UNDERGROUND_ORES, 
					Biome.createCompositeFeature(
						Feature.MINABLE, 
						new MinableConfig(IS_BEDROCK, ModBlocks.carbonadoOre.getDefaultState(), 3), 
						new CountRange(), 
						placementConfigNetherBottom
					)
				);
			}
			//Overworld
			else {
				biome.addFeature(
					Decoration.UNDERGROUND_ORES, 
					Biome.createCompositeFeature(
						Feature.MINABLE, 
						new MinableConfig(IS_BEDROCK, ModBlocks.carbonadoOre.getDefaultState(), 3), 
						new CountRange(), 
						placementConfigOverworld
					)
				);
			}
		}
	}
}
