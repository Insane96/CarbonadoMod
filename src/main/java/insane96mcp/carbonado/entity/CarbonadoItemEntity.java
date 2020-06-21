package insane96mcp.carbonado.entity;

import insane96mcp.carbonado.setup.ModConfig;
import insane96mcp.carbonado.setup.ModItems;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class CarbonadoItemEntity extends ItemEntity {

	public CarbonadoItemEntity(World worldIn, double x, double y, double z, ItemStack stack) {
		super(worldIn, x, y, z, stack);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		int shardsAmount = ModConfig.COMMON.amountPerCarbonado.get();
		if (shardsAmount == 0)
			return false;

		World world = this.world;
		double x = this.getPosX();
		double y = this.getPosY();
		double z = this.getPosZ();
		int carbonadoCount = this.getItem().getCount();
		//Process the damage
		super.attackEntityFrom(source, amount);
		//And check if the entity is dead
		if (this.removed) {
			if (source.isExplosion()) {
				ItemEntity shards = new ItemEntity(world, x, y, z, new ItemStack(ModItems.CARBONADO_SHARD.get(), carbonadoCount * shardsAmount));
				shards.setMotion(this.getMotion());
				world.addEntity(shards);
				world.playSound(null, x, y, z, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.NEUTRAL, 1.0f, 1.0f);
			}
		}
		return false;
	}
}
