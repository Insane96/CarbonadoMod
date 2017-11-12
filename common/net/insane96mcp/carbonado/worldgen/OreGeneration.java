package net.insane96mcp.carbonado.worldgen;

import java.util.Random;

import net.insane96mcp.carbonado.init.ModBlocks;
import net.insane96mcp.carbonado.lib.Properties;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGeneration implements IWorldGenerator {

	private final WorldGenMinable worldGenMinableNether;
	
	public OreGeneration() {
		worldGenMinableNether = new WorldGenMinable(ModBlocks.carbonadoOre.getDefaultState(), Properties.OreGeneration.orePerVein, BlockMatcher.forBlock(Blocks.BEDROCK));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		BlockPos chunkPos = new BlockPos(chunkX * 16, 0, chunkZ * 16);

		int dimension = world.provider.getDimension();
		
		if (dimension == -1 && !Properties.OreGeneration.enableNetherGeneration)
			return;
		
		if (dimension == 0 && !Properties.OreGeneration.enableOverworldGeneration)
			return;
		
		if (dimension == -1 || dimension == 0) {
			for (int i = 0; i < Properties.OreGeneration.veinPerChunk; i++) {
				worldGenMinableNether.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(2) + 3, random.nextInt(16)));
				if (dimension == -1)
					worldGenMinableNether.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(2) + 126, random.nextInt(16)));
			}
		}
	}

	
}
