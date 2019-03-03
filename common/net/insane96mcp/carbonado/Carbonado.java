package net.insane96mcp.carbonado;

import java.nio.file.Paths;
import java.util.Random;

import net.insane96mcp.carbonado.init.ModConfig;
import net.insane96mcp.carbonado.worldgen.OreGenerator;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Carbonado.MOD_ID)
public class Carbonado {
	
	public static final String MOD_ID = "carbonado";
	public static final String RESOURCE_PREFIX = MOD_ID + ":";

	public static final Random RANDOM = new Random();
	
	public Carbonado() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
	}
	


    private void setup(final FMLCommonSetupEvent event)
    {    	
       	ModLoadingContext.get().registerConfig(Type.COMMON, ModConfig.SPEC);
       	ModConfig.Init(Paths.get("config", MOD_ID + ".toml"));
       	
       	OreGenerator.Init();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        
    }
}
