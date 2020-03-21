package insane96mcp.carbonado.event;

import insane96mcp.carbonado.Carbonado;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Carbonado.MOD_ID)
public class EntityUpdate {

	@SubscribeEvent
	public static void onEntityTick(TickEvent.WorldTickEvent event) {
		if (event.phase != TickEvent.Phase.START)
			return;
		for (PlayerEntity playerEntity : event.world.getPlayers()) {
		}
	}
}
