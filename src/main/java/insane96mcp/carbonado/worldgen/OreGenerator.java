package insane96mcp.carbonado.worldgen;

import insane96mcp.carbonado.setup.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGenerator {

	public static void init() {
		OreFeatureConfig.FillerBlockType BEDROCK = OreFeatureConfig.FillerBlockType.create("BEDROCK", "bedrock", new BlockMatcher(Blocks.BEDROCK));
		final CountRangeConfig BOTTOM_BEDROCK_OVERWORLD = new CountRangeConfig(15, 0, 0, 6);
		final CountRangeConfig BOTTOM_BEDROCK_NETHER = new CountRangeConfig(10, 0, 0, 6);
		final CountRangeConfig TOP_BEDROCK_NETHER = new CountRangeConfig(12, 123, 123, 128);
		final int VEIN_SIZE = 3;
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			if (biome.getCategory().equals(Biome.Category.NETHER)) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(Feature.ORE,
								new OreFeatureConfig(
										BEDROCK,
										ModBlocks.carbonadoOre.getDefaultState(),
										VEIN_SIZE
								),
								Placement.COUNT_RANGE, BOTTOM_BEDROCK_NETHER
						)
				);
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(Feature.ORE,
								new OreFeatureConfig(
										BEDROCK,
										ModBlocks.carbonadoOre.getDefaultState(),
										VEIN_SIZE
								),
								Placement.COUNT_RANGE, TOP_BEDROCK_NETHER
						)
				);
			}
			else if (!biome.getCategory().equals(Biome.Category.NETHER) && !biome.getCategory().equals(Biome.Category.THEEND)) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(Feature.ORE,
								new OreFeatureConfig(
										BEDROCK,
										ModBlocks.carbonadoOre.getDefaultState(),
										VEIN_SIZE
								),
								Placement.COUNT_RANGE, BOTTOM_BEDROCK_OVERWORLD
						)
				);
			}
		}
	}
}
