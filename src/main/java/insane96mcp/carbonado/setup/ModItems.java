package insane96mcp.carbonado.setup;

import insane96mcp.carbonado.Carbonado;
import net.minecraft.item.*;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {
	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_ITEM)
	public static Item carbonado;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_SHARD)
	public static Item carbonadoShard;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_SHARD_MOLTEN)
	public static Item carbonadoShardMolten;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_PICKAXE)
	public static PickaxeItem carbonadoPickaxe;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_SHOVEL)
	public static ShovelItem carbonadoShovel;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_AXE)
	public static AxeItem carbonadoAxe;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_HOE)
	public static HoeItem carbonadoHoe;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_SWORD)
	public static SwordItem carbonadoSword;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_HELMET)
	public static ArmorItem carbonadoHelmet;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_CHESTPLATE)
	public static ArmorItem carbonadoChestplate;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_LEGGINGS)
	public static ArmorItem carbonadoLeggings;

	@ObjectHolder(Carbonado.RESOURCE_PREFIX + Strings.Names.CARBONADO_BOOTS)
	public static ArmorItem carbonadoBoots;
}
