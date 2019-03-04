package net.insane96mcp.carbonado.worldgen;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IChunkGenSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

public class ModMinableFeature extends Feature<ModMinableConfig> {

	@Override
	public boolean place(IWorld world, IChunkGenerator<? extends IChunkGenSettings> chunkGenerator,
			Random random, BlockPos pos, ModMinableConfig minableConfig) {
		IBlockState state = world.getBlockState(pos);
        if (state.isReplaceableOreGen(world.getWorld(), pos, minableConfig.canReplace))
        {
            world.setBlockState(pos, minableConfig.state, 2);
            return true;
        }

        return false;
	}	
}
