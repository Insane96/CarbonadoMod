package insane96mcp.carbonado;

import insane96mcp.carbonado.worldgen.OreGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Carbonado.MOD_ID)
public class Carbonado {
	public static final String MOD_ID = "carbonado";
	public static final String RESOURCE_PREFIX = MOD_ID + ":";

	public static final Logger LOGGER = LogManager.getLogger();

	public Carbonado() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, insane96mcp.carbonado.setup.ModConfig.COMMON_SPEC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		OreGenerator.init();
	}
}
