package insane96mcp.carbonado.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class CarbonadoGlassBlock extends GlassBlock {

	public CarbonadoGlassBlock() {
		super(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.9f, 9f).sound(SoundType.GLASS).notSolid());
	}

	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 15;
	}
}
