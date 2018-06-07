package net.insane96mcp.carbonado.lib;

public class Properties {
	
	public static void Init() {
		General.Init();
		Tool.Init();
		Armor.Init();
		OreGeneration.Init();
		Shards.Init();
	}
	
	public static class General{
		public static float carbonadoSwordChance;
		public static int glassLightBlocking;
		public static boolean swordChanceDifficultyBased;
		
		public static void Init() {
			glassLightBlocking = Config.LoadIntProperty("general", "carbonado_glass_light_blocking", "Light value removed from actual light that passes through a Carbonado Glass (0-15)", 10);
			carbonadoSwordChance = Config.LoadFloatProperty("general", "carbonado_wither_chance", "Chance for Wither Skeletons to have Carbonado Sword (0.0-100.0)", 5f);
			swordChanceDifficultyBased = Config.LoadBoolProperty("general", "carbonado_wither_difficulty_based", "If the world's difficulty should affect the chance for a wither skeleton to get a carbonado sword.\nNormal Difficulty: chance equal to carbonado_wither_chance, Easy Difficulty: half chance, Hard Difficulty: double chance\n", true);
		}
	}
	
	public static class Shards{
		public static int countAtBaseHeight;
		public static int baseHeightFalltime;
		public static int minHeightFalltime;
		
		public static boolean oldMoltenShardTexture;

		public static void Init() {
		countAtBaseHeight = Config.LoadIntProperty("shards", "count_at_base_height", "Number of shards dropped at base_height_falltime", 128);
		baseHeightFalltime = Config.LoadIntProperty("shards", "base_height_falltime", "Anvil height to drop count_at_base_height specified amount\nMath behind the calculations for shard drops at other height levels isn't easy\nE.g. The default value: 108, means a falling anvil from 128 blocks\nFrom 128 blocks (108 falltime) the carbonado block will drop count_at_base_height number of shards\n", 108);
		minHeightFalltime = Config.LoadIntProperty("shards", "min_height_falltime", "Anvil minimum height to fall for the carbonado block to be destroyed\nE.g. The default value: 27, means a falling anvil from 12 blocks\nE.g. From 12 blocks (27 falling_time) the carbonado block will drop 32 shards\n", 27);
		
		oldMoltenShardTexture = Config.LoadBoolProperty("shards", "old_molten_shard_texture", "Set to true to use the horrible, original and old (pre-1.1.1) Molten Shard Texture", false);
		}
	}
	public static class Tool{
		public static int harvestLevel;
		public static int maxUses;
		public static float efficency;
		public static float baseDamage;
		public static int enchantability;
		public static void Init() {
			harvestLevel = Config.LoadIntProperty("tools_and_weapon", "harvest_level", "Harvest Level for Carbonado Tools\n(0: Wood/Gold; 1: Stone, 2: Iron, 3: Diamond, 4: Carbonado)\n", 4);
			maxUses = Config.LoadIntProperty("tools_and_weapon", "max_uses", "Durability for Carbonado Tools and Sword", 2343);
			efficency = Config.LoadFloatProperty("tools_and_weapon", "efficency", "Efficency for Carbonado Tools", 12f);
			baseDamage = Config.LoadFloatProperty("tools_and_weapon", "base_damage", "Base damage for Carbonado Tools and Sword", 4f);
			enchantability = Config.LoadIntProperty("tools_and_weapon", "enchantability", "Enchantability for Carbonado Tools and Sword", 13);
		}
	}
	
	public static class Armor{
		public static int baseDurability;
		public static int[] armorPoints;
		public static int enchantability;
		public static float toughness;
		
		public static void Init() {
			baseDurability = Config.LoadIntProperty("armor", "base_durability", "Base durability for Carbonado Armor\n(this value is multiplied by [11, 16, 15, 13] respectively from helmet to boots)\n", 50);
			armorPoints = Config.LoadIntListProperty("armor", "armor_points", "Armor points for Carbonado Armor", new int[] {4, 7, 8, 5});
			enchantability = Config.LoadIntProperty("armor", "enchantability", "Enchantability for Carbonado Armor", 12);
			toughness = Config.LoadFloatProperty("armor", "toughness", "Toughness for Carbonado Armor", 3f);
		}
	}
	
	public static class OreGeneration{
		public static int netherVeinPerChunk;
		public static int overworldVeinPerChunk;
		
		public static void Init() {
			netherVeinPerChunk = Config.LoadIntProperty("ore_generation", "nether_ore_per_chunk", "Ores that try to spawn in a nether chunk, both top and bottom of the nether", 5);
			overworldVeinPerChunk = Config.LoadIntProperty("ore_generation", "overworld_ore_per_chunk", "Ores that try to spawn in a chunk in the overworld", 7);
		}
	}
}
