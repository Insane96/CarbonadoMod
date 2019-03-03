package net.insane96mcp.carbonado.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class BlockCarbonado extends Block{

	public BlockCarbonado(String id) {
		super(Block.Properties.create(Material.IRON, MaterialColor.BLACK).hardnessAndResistance(15.0f, 15.0f).sound(SoundType.METAL));
		
		setRegistryName(id);
	}
	
	@Override
	public boolean isBeaconBase(IBlockState state, IWorldReader world, BlockPos pos, BlockPos beacon) {
		return true;
	}
}
