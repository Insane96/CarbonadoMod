package net.insane96mcp.carbonado.events;

import net.minecraft.world.IWorldEventListener;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldLoad {
	
	 @SubscribeEvent
	 public static void WorldEventLoad(WorldEvent.Load event) {
		 IWorldEventListener WorldEventListener = new WorldEventListener();
		 event.getWorld().addEventListener(WorldEventListener);
	 }
}
