package net.insane96mcp.carbonado.proxies;

import net.insane96mcp.carbonado.init.ModBlocks;
import net.insane96mcp.carbonado.init.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void PreInit(FMLPreInitializationEvent event) {		
		ModItems.Init();
		ModBlocks.Init();
	}
	
	public void Init(FMLInitializationEvent event) {
		
	}
	
	public void PostInit(FMLPostInitializationEvent event) {
		ModItems.PostInit();
		ModBlocks.PostInit();
	}
}
