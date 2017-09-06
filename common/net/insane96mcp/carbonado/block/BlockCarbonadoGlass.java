package net.insane96mcp.carbonado.block;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.lib.Names;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCarbonadoGlass extends BlockGlass{

	public BlockCarbonadoGlass() {
		super(Material.GLASS, false);
		this.setHardness(0.9f);
		this.setResistance(10f);
		this.setLightOpacity(10);
		this.setSoundType(SoundType.GLASS);
	}

	
	@Override
	public String getUnlocalizedName() {
		return "tile." + Carbonado.RESOURCE_PREFIX + Names.CARBONADO_GLASS;
	}
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
	
	@Override
	public boolean canDropFromExplosion(Explosion explosionIn) {
		return true;
	}
}
