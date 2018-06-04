package net.insane96mcp.carbonado.worldgen;

import java.util.Random;

import net.insane96mcp.carbonado.init.ModBlocks;
import net.insane96mcp.carbonado.lib.Properties;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGeneration implements IWorldGenerator {

	private final WorldGenMinable worldGenMinableNether;
	private final WorldGenMinable worldGenMinableOverworld;
	
	public OreGeneration() {
		worldGenMinableNether = new WorldGenMinable(ModBlocks.carbonadoOre.getDefaultState(), Properties.OreGeneration.netherOrePerVein, BlockMatcher.forBlock(Blocks.BEDROCK));
		worldGenMinableOverworld = new WorldGenMinable(ModBlocks.carbonadoOre.getDefaultState(), Properties.OreGeneration.overworldOrePerVein, BlockMatcher.forBlock(Blocks.BEDROCK));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		BlockPos pos = new BlockPos(chunkX * 16, 0, chunkZ * 16);

		int dimension = world.provider.getDimension();

		GenerateNether(random, chunkX, chunkZ, world, pos, dimension);
		GenerateOverworld(random, chunkX, chunkZ, world, pos, dimension);
	}

	private void GenerateNether(Random random, int chunkX, int chunkZ, World world, BlockPos pos, int dimension) {		
		if (dimension == -1 && Properties.OreGeneration.netherVeinPerChunk <= 0)
			return;
		
		if (dimension == -1) {
			for (int i = 0; i < Properties.OreGeneration.netherVeinPerChunk; i++) {
				worldGenMinableNether.generate(world, random, pos.add(random.nextInt(16), random.nextInt(2) + 3, random.nextInt(16)));
				worldGenMinableNether.generate(world, random, pos.add(random.nextInt(16), random.nextInt(2) + 126, random.nextInt(16)));
			}
		}
	}
	
	private void GenerateOverworld(Random random, int chunkX, int chunkZ, World world, BlockPos pos, int dimension) {
		
		if (dimension == 0 && Properties.OreGeneration.overworldVeinPerChunk <= 0)
			return;

		if (dimension == 0) {
			for (int i = 0; i < Properties.OreGeneration.overworldVeinPerChunk; i++) {
				worldGenMinableNether.generate(world, random, pos.add(random.nextInt(16), random.nextInt(2) + 3, random.nextInt(16)));
			}
		}
	}
}
