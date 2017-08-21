package net.insane96mcp.carbonado.init;

import java.io.Console;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenOres implements IWorldGenerator {

	private final WorldGenMinable worldGenMinableNether;
	
	public GenOres() {
		worldGenMinableNether = new WorldGenMinable(ModBlocks.carbonadoOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.BEDROCK));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		BlockPos chunkPos = new BlockPos(chunkX * 16, 0, chunkZ * 16);

		int dimension = world.provider.getDimension();
		
		if (dimension == -1 || dimension == 0) {
			for (int i = 0; i < 12; i++) {
				worldGenMinableNether.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(2) + 3, random.nextInt(16)));
				if (dimension == -1)
					worldGenMinableNether.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(2) + 126, random.nextInt(16)));
			}
		}
	}

	
}
