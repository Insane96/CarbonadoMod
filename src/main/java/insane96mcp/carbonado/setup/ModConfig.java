package insane96mcp.carbonado.setup;

import insane96mcp.carbonado.Carbonado;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = Carbonado.MOD_ID)
public class ModConfig {
	public static final ForgeConfigSpec COMMON_SPEC;
	public static final CommonConfig COMMON;

	static {
		final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
		COMMON = specPair.getLeft();
		COMMON_SPEC = specPair.getRight();
	}

	public static class CommonConfig {

		public final Shards shards;

		public CommonConfig(final ForgeConfigSpec.Builder builder) {
			shards = new Shards(builder);
		}

		public static class Shards {
			public static String name = "shards";

			public static ConfigValue<Integer> minHeight;
			public static ConfigValue<Integer> amountAtMinHeight;
			public static ConfigValue<Integer> maxAmount;

			public Shards(ForgeConfigSpec.Builder builder) {
				builder.push(name);
				minHeight = builder
						.comment("Anvil minimum height to fall for the carbonado to be destroyed and give shards")
						.defineInRange("min_height", 4, 1, 255);
				amountAtMinHeight = builder
						.comment("Amount of shards dropped at min_height, increased by 1 for each block higher")
						.defineInRange("amount_at_min_height", 8, 1, 256);
				maxAmount = builder
						.comment("Maximum shards that can drop a single carbonado")
						.defineInRange("max_amount", 24, 1, 256);
				builder.pop();
			}
		}
	}
}
