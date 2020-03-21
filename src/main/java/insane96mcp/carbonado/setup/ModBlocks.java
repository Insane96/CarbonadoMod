package insane96mcp.carbonado.setup;

import insane96mcp.carbonado.Carbonado;
import insane96mcp.carbonado.block.CarbonadoBlock;
import insane96mcp.carbonado.block.CarbonadoGlassBlock;
import insane96mcp.carbonado.block.CarbonadoGlassPaneBlock;
import insane96mcp.carbonado.block.CarbonadoOreBlock;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_BLOCK)
	public static CarbonadoBlock carbonadoBlock;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_ORE)
	public static CarbonadoOreBlock carbonadoOre;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_GLASS)
	public static CarbonadoGlassBlock carbonadoGlass;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_GLASS_PANE)
	public static CarbonadoGlassPaneBlock carbonadoGlassPane;
}
