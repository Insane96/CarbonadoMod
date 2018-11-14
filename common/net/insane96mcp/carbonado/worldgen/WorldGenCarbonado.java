package net.insane96mcp.carbonado.worldgen;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCarbonado extends WorldGenerator {

	private final IBlockState oreBlock;
    private final Predicate<IBlockState> predicate;

    public WorldGenCarbonado(IBlockState state, int blockCount)
    {
        this(state, new WorldGenCarbonado.StonePredicate());
    }

    public WorldGenCarbonado(IBlockState state, Predicate<IBlockState> p_i45631_3_)
    {
        this.oreBlock = state;
        this.predicate = p_i45631_3_;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
    	position = position.add(8, 0, 8);
        IBlockState state = worldIn.getBlockState(position);
        if (state.getBlock().isReplaceableOreGen(state, worldIn, position, this.predicate))
        {
            worldIn.setBlockState(position, this.oreBlock, 2);
        }

        return true;
    }

    static class StonePredicate implements Predicate<IBlockState>
    {
        private StonePredicate()
        {
        }

        public boolean apply(IBlockState p_apply_1_)
        {
            if (p_apply_1_ != null && p_apply_1_.getBlock() == Blocks.STONE)
            {
                BlockStone.EnumType blockstone$enumtype = (BlockStone.EnumType)p_apply_1_.getValue(BlockStone.VARIANT);
                return blockstone$enumtype.isNatural();
            }
            else
            {
                return false;
            }
        }
    }
}
