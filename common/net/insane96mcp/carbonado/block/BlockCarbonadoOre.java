package net.insane96mcp.carbonado.block;

import java.util.Random;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BlockCarbonadoOre extends BlockOre{
	
	public BlockCarbonadoOre(String id) {
		super(Block.Properties.create(Material.ROCK).hardnessAndResistance(15f, 33.3f));
		
		setRegistryName(id);
	}
	
	@Override
	//TODO Overhaul fortune mechanic
	public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
		if (fortune > 0)
			fortune--;
		return ModItems.carbonado;
	}
	
	@Override
	public int getItemsToDropCount(IBlockState state, int fortune, World worldIn, BlockPos pos, Random random) {
		return super.getItemsToDropCount(state, fortune, worldIn, pos, random);
	}
	
	@Override
	public boolean canSilkHarvest(IBlockState state, IWorldReader world, BlockPos pos, EntityPlayer player) {
		return false;
	}
	
	@Override
	public void onPlayerDestroy(IWorld worldIn, BlockPos pos, IBlockState state) {
		worldIn.setBlockState(pos, Blocks.BEDROCK.getDefaultState(), 3);
	}
	
	@Override
	public int getExpDrop(IBlockState state, IWorldReader reader, BlockPos pos, int fortune) {
		return Carbonado.RANDOM.nextInt(7) + 8;
	}
}
