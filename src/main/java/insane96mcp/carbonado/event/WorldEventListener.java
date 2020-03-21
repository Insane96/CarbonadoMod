package insane96mcp.carbonado.event;

import insane96mcp.carbonado.Carbonado;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Carbonado.MOD_ID)
public class WorldEventListener {

	@SubscribeEvent
	public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (event.getEntity() instanceof FallingBlockEntity)
			System.out.println("IT WORKS!");
	}
}
