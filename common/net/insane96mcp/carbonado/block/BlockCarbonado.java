package net.insane96mcp.carbonado.block;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCarbonado extends Block{

	public BlockCarbonado() {
		super(Material.IRON);
	}
	
	
	@Override
	public String getUnlocalizedName() {
		return "tile." + Carbonado.RESOURCE_PREFIX + Names.CARBONADO_BLOCK;
	}
}
