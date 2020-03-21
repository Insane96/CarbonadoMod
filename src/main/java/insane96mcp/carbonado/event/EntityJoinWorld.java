package insane96mcp.carbonado.event;

import insane96mcp.carbonado.Carbonado;
import insane96mcp.carbonado.item.material.CarbonadoItemEntity;
import insane96mcp.carbonado.setup.ModItems;
import net.minecraft.entity.item.ItemEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Carbonado.MOD_ID)
public class EntityJoinWorld {

	@SubscribeEvent
	public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (event.getWorld().isRemote)
			return;
		if (!event.getEntity().getClass().equals(ItemEntity.class))
			return;
		ItemEntity itemEntity = (ItemEntity) event.getEntity();
		if (itemEntity.getItem().getItem() != ModItems.carbonado)
			return;
		CarbonadoItemEntity carbonadoItemEntity = new CarbonadoItemEntity(itemEntity.world, itemEntity.posX, itemEntity.posY, itemEntity.posZ, itemEntity.getItem());
		carbonadoItemEntity.setPickupDelay(itemEntity.pickupDelay);
		carbonadoItemEntity.setMotion(itemEntity.getMotion());
		event.getWorld().addEntity(carbonadoItemEntity);
		itemEntity.remove();
	}
}
