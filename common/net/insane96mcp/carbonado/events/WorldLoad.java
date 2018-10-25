package net.insane96mcp.carbonado.events;

import net.insane96mcp.carbonado.Carbonado;
import net.minecraft.world.IWorldEventListener;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Carbonado.MOD_ID)
public class WorldLoad {
	
	 @SubscribeEvent
	 public static void WorldEventLoad(WorldEvent.Load event) {
		 IWorldEventListener WorldEventListener = new WorldEventListener();
		 event.getWorld().addEventListener(WorldEventListener);
	 }
}
