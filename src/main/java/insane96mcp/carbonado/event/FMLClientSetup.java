package insane96mcp.carbonado.event;

import insane96mcp.carbonado.Carbonado;
import insane96mcp.carbonado.setup.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Carbonado.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FMLClientSetup {

	@SubscribeEvent
	public static void clientStuff(final FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(ModBlocks.CARBONADO_GLASS.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(ModBlocks.CARBONADO_GLASS_PANE.get(), RenderType.getTranslucent());
	}
}
