package net.insane96mcp.carbonado.init;

import java.nio.file.Path;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class ModConfig {
	
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static ForgeConfigSpec SPEC;
	
	public static void Init(Path file) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(file)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        SPEC.setConfig(configData);
	}
	
	public static class OreGeneration {
		public static String name = "ore_generation";
		
		
		public static ConfigValue<Integer> orePerChunkNether;
		public static ConfigValue<Integer> orePerChunkOverworld;
		
		public static void Init() {
			BUILDER.push(name);
			orePerChunkNether = BUILDER
				.comment("Number of ores generated per chunk in the Nether (both top and bottom of the nether)")
				.defineInRange("ore_per_chunk_nether", 5, 0, 128);
			orePerChunkOverworld = BUILDER
				.comment("Number of ores generated per chunk in the Overworld")
				.defineInRange("ore_per_chunk_overworld", 7, 0, 128);
			BUILDER.pop();
		}
	}
	
	public static class Shards {
		public static String name = "shards";

		public static ConfigValue<Integer> minHeight;
		public static ConfigValue<Integer> amountAtMinHeight;
		public static ConfigValue<Integer> maxAmount;
		
		public static void Init() {
			BUILDER.push(name);
			minHeight = BUILDER
				.comment("Anvil minimum height to fall for the carbonado to be destroyed and give shards")
				.defineInRange("min_height", 4, 1, 255);
			amountAtMinHeight = BUILDER
				.comment("Amount of shards dropped at min_height, increased by 1 for each block higher")
				.defineInRange("amount_at_min_height", 8, 1, 256);
			maxAmount = BUILDER
				.comment("Maximum shards that can drop a single carbonado")
				.defineInRange("max_amount", 24, 1, 256);
			BUILDER.pop();
		}
	}
	
	static {
		OreGeneration.Init();
		Shards.Init();
		
		SPEC = BUILDER.build();
	}
}