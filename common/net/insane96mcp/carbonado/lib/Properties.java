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
		
		@Name("Ore Generation")
		public OreGeneration oreGeneration = new OreGeneration();
		
		public static class OreGeneration {
			@Name("Nether: Ore Per Chunk")
			@Comment("Ores that try to spawn in a nether chunk, both top and bottom of the nether")
			public int orePerChunkNether = 5;
			@Name("Overworld: Ore Per Chunk")
			@Comment("Ores that try to spawn in a chunk in the overworld")
			public int orePerChunkOverworld = 7;
		}
		
		
		public Shards shards = new Shards();
		
		public static class Shards {
			@Name("Min Height")
			@Comment("Anvil minimum height to fall for the carbonado to be destroyed")
			public int minHeight = 4;
			@Name("Amount at Min Height")
			@Comment("Number of shards dropped at min_height, increased by 1 for each block higher")
			public int countAtMinHeight = 8;
			@Name("Max Amount")
			@Comment("Maximum shards that can drop a single carbonado")
			public int maxCount = 16;
		}
	}
}
