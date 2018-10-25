package net.insane96mcp.carbonado.block;

import java.util.Random;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.lib.Strings.Names;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarbonadoOre extends BlockOre{
	
	public BlockCarbonadoOre() {
		super();
	}
	
	@Override
	public String getTranslationKey() {
		return "tile." + Carbonado.RESOURCE_PREFIX + Names.CARBONADO_ORE;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if (fortune > 0)
			fortune--;
		return ModItems.carbonadoItem;
	}
	
	@Override
	public boolean canSilkHarvest(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		return false;
	}
	
	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.setBlockState(pos, Blocks.BEDROCK.getDefaultState());
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		return Carbonado.random.nextInt(7) + 8;
	}
}
