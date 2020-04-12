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

			public ConfigValue<Integer> amountPerCarbonado;

			public Shards(ForgeConfigSpec.Builder builder) {
				builder.push(name);
				amountPerCarbonado = builder
						.comment("How many Carbonado Shards are given by blowing up one Carbonado?")
						.defineInRange("amount_per_carbonado", 8, 1, 64);
				builder.pop();
			}
		}
	}
}
