package net.insane96mcp.carbonado.proxies;

import net.insane96mcp.carbonado.events.EntityJoinWorld;
import net.insane96mcp.carbonado.events.WorldLoad;
import net.insane96mcp.carbonado.init.ModBlocks;
import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.lib.Config;
import net.insane96mcp.carbonado.lib.Properties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void PreInit(FMLPreInitializationEvent event) {
		Config.config = new Configuration(event.getSuggestedConfigurationFile());
		Config.SyncConfig();
		Properties.Init();
		
		ModItems.Init();
		ModBlocks.Init();
	}
	
	public void Init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(EntityJoinWorld.class);
		MinecraftForge.EVENT_BUS.register(WorldLoad.class);
	}
	
	public void PostInit(FMLPostInitializationEvent event) {
		Config.SaveConfig();
		ModItems.PostInit();
		ModBlocks.PostInit();
	}
}
