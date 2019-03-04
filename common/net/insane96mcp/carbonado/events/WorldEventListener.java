package net.insane96mcp.carbonado.events;

import java.util.ArrayList;
import java.util.List;

import net.insane96mcp.carbonado.init.ModConfig;
import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.utils.FallingAnvil;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldEventListener;
import net.minecraft.world.World;

public class WorldEventListener implements IWorldEventListener {
	
    private boolean isAnvil(Entity entity) {
        if(!(entity instanceof EntityFallingBlock))
        	return false;
        EntityFallingBlock entityFallingBlock = (EntityFallingBlock)entity;
        for (Block block : BlockTags.ANVIL.getAllElements()) {
        	if (entityFallingBlock.getBlockState().getBlock().equals(block))
                return true;
		}
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

		if (fallHeight < ModConfig.Shards.minHeight.get())
			return;
		
		World world = entity.getEntityWorld();
		BlockPos pos = entity.getPosition();
		AxisAlignedBB aabb = new AxisAlignedBB(pos, pos.add(1, 1, 1));
		List<EntityItem> entityItems = world.getEntitiesWithinAABB(EntityItem.class, aabb);
		if (entityItems.isEmpty())
			return;
		
		for (EntityItem entityItem : entityItems) {
			ItemStack stack = entityItem.getItem();
			if (ItemStack.areItemsEqual(stack, new ItemStack(ModItems.carbonado))) {
				int dropCount = ModConfig.Shards.amountAtMinHeight.get() + (fallHeight - ModConfig.Shards.minHeight.get()) * stack.getCount();

	            if (dropCount > ModConfig.Shards.maxAmount.get() * stack.getCount())
	            	dropCount = ModConfig.Shards.maxAmount.get() * stack.getCount();
	            EntityItem shards = new EntityItem(world, (double)pos.getX() + .5d, (double)pos.getY() + .5d, (double)pos.getZ() + .5d, new ItemStack(ModItems.carbonadoShard, dropCount));
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
	public void notifyBlockUpdate(IBlockReader worldIn, BlockPos pos, IBlockState oldState, IBlockState newState, int flags) { }

	@Override
	public void notifyLightSet(BlockPos pos) { }

	@Override
	public void markBlockRangeForRenderUpdate(int x1, int y1, int z1, int x2, int y2, int z2) { }

	@Override
	public void playSoundToAllNearExcept(EntityPlayer player, SoundEvent soundIn, SoundCategory category, double x, double y, double z, float volume, float pitch) { }

	@Override
	public void playRecord(SoundEvent soundIn, BlockPos pos) { }

	@Override
	public void addParticle(IParticleData particleData, boolean alwaysRender, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) { }

	@Override
	public void addParticle(IParticleData particleData, boolean ignoreRange, boolean minimizeLevel, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) { }

	@Override
	public void broadcastSound(int soundID, BlockPos pos, int data) { }

	@Override
	public void playEvent(EntityPlayer player, int type, BlockPos blockPosIn, int data) { }

	@Override
	public void sendBlockBreakProgress(int breakerId, BlockPos pos, int progress) { }
}
