package net.insane96mcp.carbonado.lib;

import net.insane96mcp.carbonado.Carbonado;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;

@Config(modid = Carbonado.MOD_ID, category = "", name = "Carbonado")
public class Properties {
	
	@Name("Config")
	public static final ConfigOptions config = new ConfigOptions();
	
	public static class ConfigOptions {
		
		public OreGeneration oreGeneration = new OreGeneration();
		
		public static class OreGeneration {
			@Comment("Ores that try to spawn in a nether chunk, both top and bottom of the nether")
			public int orePerChunkNether = 4;
			@Comment("Ores that try to spawn in a chunk in the overworld")
			public int orePerChunkOverworld = 6;
		}
		
		
		public Shards shards = new Shards();
		
		public static class Shards {
			@Comment("Anvil minimum height to fall for the carbonado to be destroyed")
			public int minHeight = 4;
			@Comment("Number of shards dropped at min_height, increased by 1 for each block higher")
			public int countAtMinHeight = 8;
			@Comment("Maximum shards that can drop a single carbonado")
			public int maxCount = 16;
		}
	}
}
