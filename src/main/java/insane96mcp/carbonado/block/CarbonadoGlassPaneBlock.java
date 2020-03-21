package insane96mcp.carbonado.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CarbonadoGlassPaneBlock extends PaneBlock {

	public CarbonadoGlassPaneBlock() {
		super(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.9f).sound(SoundType.GLASS));
	}

	/*@Override
	public int quantityDropped(BlockState state, Random random) {
		return random.nextFloat() < 0.5f ? 1 : 0;
	}*/

	/*@Override
	public IItemProvider getItemDropped(BlockState state, World worldIn, BlockPos pos, int fortune) {
		return ModBlocks.carbonadoGlassPane;
	}*/

	@OnlyIn(Dist.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 15;
	}
}
