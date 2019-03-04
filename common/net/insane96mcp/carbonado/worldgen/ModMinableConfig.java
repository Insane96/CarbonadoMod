package net.insane96mcp.carbonado.worldgen;

import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class ModMinableConfig implements IFeatureConfig {
	   public static final Predicate<IBlockState> IS_ROCK = (p_210462_0_) -> {
	      if (p_210462_0_ == null) {
	         return false;
	      } else {
	         Block block = p_210462_0_.getBlock();
	         return block == Blocks.BEDROCK;
	      }
	   };
	   public final Predicate<IBlockState> canReplace;
	   public final IBlockState state;

	   public ModMinableConfig(Predicate<IBlockState> canReplaceIn, IBlockState stateIn) {
	      this.state = stateIn;
	      this.canReplace = canReplaceIn;
	   }
}
