package insane96mcp.carbonado.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

public class CarbonadoOreBlock extends OreBlock {

	public CarbonadoOreBlock() {
		super(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.0F, 9f));
	}

	/*@Override
	public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
		return ModItems.carbonado;
	}

	@Override
	public int getItemsToDropCount(IBlockState state, int fortune, World worldIn, BlockPos pos, Random random) {
		if (fortune > 0 && this != this.getItemDropped(this.getStateContainer().getValidStates().iterator().next(), worldIn, pos, fortune)) {
			int i = random.nextInt(fortune + 4) - 3;
			if (i < 0) {
				i = 0;
			}

			return this.quantityDropped(state, random) * (i + 1);
		}
		else {
			return this.quantityDropped(state, random);
		}
	}*/

	@Override
	public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
		worldIn.setBlockState(pos, Blocks.BEDROCK.getDefaultState(), 3);
	}

	@Override
	public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
		return MathHelper.nextInt(new Random(), 6, 14);
	}

}
