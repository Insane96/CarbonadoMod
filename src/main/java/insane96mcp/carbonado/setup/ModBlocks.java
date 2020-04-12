package insane96mcp.carbonado.setup;

import insane96mcp.carbonado.Carbonado;
import insane96mcp.carbonado.block.CarbonadoBlock;
import insane96mcp.carbonado.block.CarbonadoGlassBlock;
import insane96mcp.carbonado.block.CarbonadoGlassPaneBlock;
import insane96mcp.carbonado.block.CarbonadoOreBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Carbonado.MOD_ID);

	public static final RegistryObject<CarbonadoBlock> CARBONADO_BLOCK = BLOCKS.register(Strings.RegistryNames.CARBONADO_BLOCK, CarbonadoBlock::new);
	public static final RegistryObject<CarbonadoOreBlock> CARBONADO_ORE = BLOCKS.register(Strings.RegistryNames.CARBONADO_ORE, CarbonadoOreBlock::new);
	public static final RegistryObject<CarbonadoGlassBlock> CARBONADO_GLASS = BLOCKS.register(Strings.RegistryNames.CARBONADO_GLASS, CarbonadoGlassBlock::new);
	public static final RegistryObject<CarbonadoGlassPaneBlock> CARBONADO_GLASS_PANE = BLOCKS.register(Strings.RegistryNames.CARBONADO_GLASS_PANE, CarbonadoGlassPaneBlock::new);
}
