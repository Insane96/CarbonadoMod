package net.insane96mcp.carbonado.lib;

import net.insane96mcp.carbonado.Config;

public class Stats {
	public static float carbonadoSwordChance;
	
	public static int shardAtBaseHeight;
	public static int baseHeightFalltime;
	public static int minHeightFalltime;
	
	public static int glassLightBlocking;
	
	public static boolean oldMoltenShardTexture;
	
	public static void Init() {
		shardAtBaseHeight = Config.LoadIntProperty("shards", "shard_at_base_height", "Number of shards dropped at base_height_falltime", 128);
		baseHeightFalltime = Config.LoadIntProperty("shards", "base_height_falltime", "Anvil height to drop shard_at_base_height specified amount\nMath behind the calculations for shard drops at other height levels isn't easy\nE.g. The default value: 108, means a falling anvil from 128 blocks\nFrom 128 blocks (108 falltime) the carbonado block will drop shard_at_base_height number of shards\n", 108);
		minHeightFalltime = Config.LoadIntProperty("shards", "min_height_falltime", "Anvil minimum height to fall for the carbonado block to be destroyed\nE.g. The default value: 27, means a falling anvil from 12 blocks\nFrom 12 blocks (27 fallingtime) the carbonado block will drop 32 shards\n", 27);
		
		glassLightBlocking = Config.LoadIntProperty("general", "carbonado_glass_light_blocking", "Light value removed from actual light that passes through a Carbonado Glass (0-15)", 10);
		carbonadoSwordChance = Config.LoadFloatProperty("general", "carbonado_wither_chance", "Chance for Wither Skeletons to have Carbonado Sword (1-100)", 5f);
		
		oldMoltenShardTexture = Config.LoadBoolProperty("general", "old_molten_shard_texture", "Set to true to use the horrible, original and old (pre-1.1.1) Molten Shard Texture", false);
		
		ToolMaterial.Init();
		ArmorMaterial.Init();
		OreGeneration.Init();
		
	}
	
	public static class ToolMaterial{
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
	
	public static class ArmorMaterial{
		public static int baseDurability;
		public static int[] armorPoints;
		public static int enchantability;
		public static float toughness;
		
		public static float armorDamageReduction;
		
		public static void Init() {
			baseDurability = Config.LoadIntProperty("armor", "base_durability", "Base durability for Carbonado Armor\n(this value is multiplied by [11, 16, 15, 13] respectively from helmet to boots)\n", 50);
			armorPoints = Config.LoadIntListProperty("armor", "armor_points", "Armor points for Carbonado Armor", new int[] {3, 8, 6, 3});
			enchantability = Config.LoadIntProperty("armor", "enchantability", "Enchantability for Carbonado Armor", 12);
			toughness = Config.LoadFloatProperty("armor", "toughness", "Toughness for Carbonado Armor", 3f);
			
			armorDamageReduction = Config.LoadFloatProperty("armor", "damage_reduction", "Percentage Damage reduction for full Carbonado Armor Set", 20f);
		}
	}
	
	public static class OreGeneration{
		public static int orePerVein;
		public static int veinPerChunk;
		
		public static void Init() {
			orePerVein = Config.LoadIntProperty("ore_generation", "ore_per_vein", "Ores Generated Per Vein", 3);
			veinPerChunk = Config.LoadIntProperty("ore_generation", "vein_per_chunk", "Veins that try to spawn in a chunk", 10);
		}
	}
}