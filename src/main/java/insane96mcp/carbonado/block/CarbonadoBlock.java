package insane96mcp.carbonado.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class CarbonadoBlock extends Block {

	public CarbonadoBlock() {
		super(Block.Properties.create(Material.IRON, MaterialColor.BLACK).hardnessAndResistance(15.0f, 15.0f).sound(SoundType.METAL));
	}

	@Override
	public boolean isBeaconBase(BlockState state, IWorldReader world, BlockPos pos, BlockPos beacon) {
		return true;
	}
}
