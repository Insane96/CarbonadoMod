package net.insane96mcp.carbonado.block;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarbonado extends Block{

	public BlockCarbonado() {
		super(Material.IRON);
	}
	
	
	@Override
	public String getTranslationKey() {
		return "tile." + Carbonado.RESOURCE_PREFIX + Names.CARBONADO_BLOCK;
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}
}
