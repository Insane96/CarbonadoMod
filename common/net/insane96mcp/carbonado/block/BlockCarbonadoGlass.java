package net.insane96mcp.carbonado.block;

import java.util.List;

import net.insane96mcp.carbonado.init.Strings.Tooltips;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockCarbonadoGlass extends BlockGlass{

	public BlockCarbonadoGlass(String id) {
		super(Block.Properties.create(Material.GLASS, MaterialColor.BLACK_TERRACOTTA).hardnessAndResistance(0.9f, 10f).sound(SoundType.GLASS));

		setRegistryName(id);
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
	
	@Override
	public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation(Tooltips.GlassCreation.base_info));
		tooltip.add(new TextComponentString(""));
		tooltip.add(new TextComponentTranslation(Tooltips.GlassCreation.base_createGlass));
	}
}
