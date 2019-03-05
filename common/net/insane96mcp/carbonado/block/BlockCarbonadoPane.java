package net.insane96mcp.carbonado.block;

import java.util.Random;

import net.insane96mcp.carbonado.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlassPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockCarbonadoPane extends BlockGlassPane{

	public BlockCarbonadoPane(String id) {
		super(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.9f).sound(SoundType.GLASS));

		setRegistryName(id);
	}
	
	@Override
	public int quantityDropped(IBlockState state, Random random) {
		return random.nextFloat() < 0.5f ? 1 : 0;
	}
	
	@Override
	public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
		return ModBlocks.carbonadoGlassPane;
	}
	
	@OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
	
	@Override
	public boolean canDropFromExplosion(Explosion explosionIn) {
		return true;
	}
	
	@Override
	public int getOpacity(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		return 15;
	}
}
