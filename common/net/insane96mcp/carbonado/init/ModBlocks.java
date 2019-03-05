package net.insane96mcp.carbonado.init;

import net.insane96mcp.carbonado.Carbonado;
import net.insane96mcp.carbonado.block.BlockCarbonado;
import net.insane96mcp.carbonado.block.BlockCarbonadoGlass;
import net.insane96mcp.carbonado.block.BlockCarbonadoOre;
import net.insane96mcp.carbonado.block.BlockCarbonadoPane;
import net.insane96mcp.carbonado.init.Strings.Names;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
	
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_BLOCK)
	public static BlockCarbonado carbonadoBlock;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_ORE)
	public static BlockCarbonadoOre carbonadoOre;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_GLASS)
	public static BlockCarbonadoGlass carbonadoGlass;
	
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Names.CARBONADO_GLASS_PANE)
	public static BlockCarbonadoPane carbonadoGlassPane;
}
