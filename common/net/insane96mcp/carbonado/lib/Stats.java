package net.insane96mcp.carbonado.lib;

import net.insane96mcp.carbonado.Config;

public class Stats {
	public static float armorDamageReduction = Config.LoadFloatProperty("armor", "damage_reduction", "Percentage Damage reduction for full Carbonado Armor Set", 20f);
	
	//public static int carbonadoSwordChance = Config.LoadIntProperty("other", "carbonado_wither_chance", "Chance for Wither Skeletons to have Carbonado Sword (1-100)", 5);
	
	public static class ToolMaterial{
		public static int harvestLevel = Config.LoadIntProperty("tools_and_weapon", "harvest_level", "Harvest Level for Carbonado Tools\n(0: Wood/Gold; 1: Stone, 2: Iron, 3: Diamond, 4: Carbonado)\n", 4);
		public static int maxUses = Config.LoadIntProperty("tools_and_weapon", "max_uses", "Durability for Carbonado Tools and Sword", 2343);
		public static float efficency = Config.LoadFloatProperty("tools_and_weapon", "efficency", "Efficency for Carbonado Tools", 12f);
		public static float baseDamage = Config.LoadFloatProperty("tools_and_weapon", "base_damage", "Base damage for Carbonado Tools and Sword", 4f);
		public static int enchantability = Config.LoadIntProperty("tools_and_weapon", "enchantability", "Enchantability for Carbonado Tools and Sword", 13);
	}
	
	public static class ArmorMaterial{
		public static int baseDurability = Config.LoadIntProperty("armor", "base_durability", "Base durability for Carbonado Armor\n(this value is multiplied by [11, 16, 15, 13] respectively from helmet to boots)\n", 50);
		public static int[] armorPoints = Config.LoadIntListProperty("armor", "armor_points", "Armor points for Carbonado Armor", new int[] {3, 8, 6, 3});
		public static int enchantability = Config.LoadIntProperty("armor", "enchantability", "Enchantability for Carbonado Armor", 12);
		public static float toughness = Config.LoadFloatProperty("armor", "toughness", "Toughness for Carbonado Armor", 3f);
	}
	
	public static class OreGeneration{
		public static int orePerVein = Config.LoadIntProperty("ore_generation", "ore_per_vein", "Ores Generated Per Vein", 3);
		public static int veinPerChunk = Config.LoadIntProperty("ore_generation", "vein_per_chunk", "Veins that try to spawn in a chunk", 10);
	}
	
	public static int shardAtBaseHeight = Config.LoadIntProperty("shards", "shard_at_base_height", "Number of shards dropped at base_height_falltime", 128);
	public static int baseHeightFalltime = Config.LoadIntProperty("shards", "base_height_falltime", "Anvil height to drop shard_at_base_height specified amount\nMath behind the calculations for shard drops at other height levels isn't easy\nE.g. The default value: 108, means a falling anvil from 128 blocks\nFrom 128 blocks (108 falltime) the carbonado block will drop shard_at_base_height number of shards\n", 108);
	public static int minHeightFalltime = Config.LoadIntProperty("shards", "min_height_falltime", "Anvil minimum height to fall for the carbonado block to be destroyed\nE.g. The default value: 27, means a falling anvil from 12 blocks\nFrom 12 blocks (27 fallingtime) the carbonado block will drop 32 shards\n", 27);
	
	public static int glassLightBlocking = Config.LoadIntProperty("other", "carbonado_glass_light_blocking", "Light value removed from actual light that passes through a Carbonado Glass (0-15)", 10);
}
