package net.insane96mcp.carbonado;

import net.insane96mcp.carbonado.init.ModBlocks;
import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.lib.CustomEventHandler;
import net.insane96mcp.carbonado.lib.Stats;
import net.insane96mcp.carbonado.lib.WorldEventListener;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void PreInit(FMLPreInitializationEvent event) {
		Config.config = new Configuration(event.getSuggestedConfigurationFile());
		Config.SyncConfig();
		Stats.Init();
		
		ModItems.Init();
		ModBlocks.Init();
	}
	
	public void Init(FMLInitializationEvent event) {
		ModItems.PostInit();
		ModBlocks.PostInit();
		MinecraftForge.EVENT_BUS.register(CustomEventHandler.class);
	}
	
	public void PostInit(FMLPostInitializationEvent event) {
		Config.SaveConfig();
	}
}
