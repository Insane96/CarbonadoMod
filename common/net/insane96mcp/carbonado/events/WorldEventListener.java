package net.insane96mcp.carbonado.events;

import java.util.ArrayList;
import java.util.List;

import net.insane96mcp.carbonado.init.ModBlocks;
import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.lib.Properties;
import net.insane96mcp.carbonado.utils.FallingAnvil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldEventListener;
import net.minecraft.world.World;
import scala.reflect.internal.Trees.New;

public class WorldEventListener implements IWorldEventListener {
	
    private boolean isAnvil(Entity entity) {
        if(!(entity instanceof EntityFallingBlock))
        	return false;
        EntityFallingBlock entityFallingBlock = (EntityFallingBlock)entity;
        if (entityFallingBlock.getBlock().getBlock() == Blocks.ANVIL)
            return true;
        return false;
    }
    
	@Override
	public void onEntityRemoved(Entity entity) {
		if (entity.getEntityWorld().isRemote)
			return;
		if (!isAnvil(entity))
			return;
		EntityFallingBlock anvil = (EntityFallingBlock)entity;
		
		int fallHeight = 0;
		for (FallingAnvil fallingAnvil : fallingAnvils) {
			if (fallingAnvil.fallingBlock.equals(anvil)) {
				fallHeight = (int) (fallingAnvil.originalY - anvil.posY);
			}
		}

		if (fallHeight < Properties.Shards.minHeight)
			return;
		
		World world = entity.getEntityWorld();
		BlockPos pos = entity.getPosition();
		AxisAlignedBB aabb = new AxisAlignedBB(pos, pos.add(1, 1, 1));
		List<EntityItem> entityItems = world.getEntitiesWithinAABB(EntityItem.class, aabb);
		if (entityItems.isEmpty())
			return;
		
		for (EntityItem entityItem : entityItems) {
			ItemStack stack = entityItem.getItem();
			if (ItemStack.areItemsEqual(stack, new ItemStack(ModItems.carbonadoItem))) {
				int dropCount = Properties.Shards.countAtMinHeight + (fallHeight - Properties.Shards.minHeight) * stack.getCount();

	            if (dropCount > Properties.Shards.maxCount * stack.getCount())
	            	dropCount = Properties.Shards.maxCount * stack.getCount();
	            EntityItem shards = new EntityItem(world, (double)pos.getX() + .5d, (double)pos.getY() + .5d, (double)pos.getZ() + .5d, new ItemStack(ModItems.carbonadoShardItem, dropCount));
	            world.spawnEntity(shards);
	            world.removeEntity(entityItem);
			}
		}
	}

	public static List<FallingAnvil> fallingAnvils = new ArrayList<FallingAnvil>();
	
	@Override
	public void onEntityAdded(Entity entityIn) {
		if (!isAnvil(entityIn))
			return;
		EntityFallingBlock anvil = (EntityFallingBlock)entityIn;
		
		for (FallingAnvil fallingAnvil : fallingAnvils) {
			if (fallingAnvil.fallingBlock.equals(anvil)) {
				return;
			}
		}

		fallingAnvils.add(new FallingAnvil(anvil, anvil.posY));
	}
	
	@Override
	public void notifyBlockUpdate(World worldIn, BlockPos pos, IBlockState oldState, IBlockState newState, int flags) {}

	@Override
	public void notifyLightSet(BlockPos pos) {}

	@Override
	public void markBlockRangeForRenderUpdate(int x1, int y1, int z1, int x2, int y2, int z2) {}

	@Override
	public void playSoundToAllNearExcept(EntityPlayer player, SoundEvent soundIn, SoundCategory category, double x,
			double y, double z, float volume, float pitch) {}

	@Override
	public void playRecord(SoundEvent soundIn, BlockPos pos) {}

	@Override
	public void spawnParticle(int particleID, boolean ignoreRange, double xCoord, double yCoord, double zCoord,
			double xSpeed, double ySpeed, double zSpeed, int... parameters) {}

	@Override
	public void spawnParticle(int p_190570_1_, boolean p_190570_2_, boolean p_190570_3_, double p_190570_4_,
			double p_190570_6_, double p_190570_8_, double p_190570_10_, double p_190570_12_, double p_190570_14_,
			int... p_190570_16_) {}

	@Override
	public void broadcastSound(int soundID, BlockPos pos, int data) {}

	@Override
	public void playEvent(EntityPlayer player, int type, BlockPos blockPosIn, int data) {}

	@Override
	public void sendBlockBreakProgress(int breakerId, BlockPos pos, int progress) {}
}
