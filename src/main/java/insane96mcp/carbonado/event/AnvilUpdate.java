package insane96mcp.carbonado.event;

import insane96mcp.carbonado.Carbonado;
import insane96mcp.carbonado.setup.ModConfig;
import insane96mcp.carbonado.setup.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Carbonado.MOD_ID)
public class AnvilUpdate {

	public final static ArrayList<EquipmentUpgrade> EQUIPMENT_UPGRADES = new ArrayList<>(Arrays.asList(
		new EquipmentUpgrade(Items.DIAMOND_AXE, 2),
		new EquipmentUpgrade(Items.DIAMOND_SHOVEL, 1),
		new EquipmentUpgrade(Items.DIAMOND_PICKAXE, 2),
		new EquipmentUpgrade(Items.DIAMOND_SWORD, 1),
		new EquipmentUpgrade(Items.DIAMOND_HOE, 1),
		new EquipmentUpgrade(Items.DIAMOND_HELMET, 3),
		new EquipmentUpgrade(Items.DIAMOND_CHESTPLATE, 4),
		new EquipmentUpgrade(Items.DIAMOND_LEGGINGS, 4),
		new EquipmentUpgrade(Items.DIAMOND_BOOTS, 2)
	));

	@SubscribeEvent
	public static void onAnvilUpdate(AnvilUpdateEvent event){
		if (ModConfig.COMMON.disableAnvilRecipes.get())
			return;

		ItemStack left = event.getLeft();
		ItemStack right = event.getRight();

		if (!right.getItem().equals(ModItems.CARBONADO.get()))
			return;

		for (EquipmentUpgrade equipmentUpgrade : EQUIPMENT_UPGRADES) {
			if (!left.getItem().equals(equipmentUpgrade.inputItem))
				continue;

			if (right.getCount() < equipmentUpgrade.materialAmount)
				continue;

			String itemName = left.getItem().getRegistryName().getPath();
			ResourceLocation carbonadoName = new ResourceLocation(Carbonado.MOD_ID, itemName.replace("diamond", "carbonado"));
			ItemStack output = new ItemStack(ForgeRegistries.ITEMS.getValue(carbonadoName));
			CompoundNBT tags = output.getTag();
			if (tags == null)
				tags = new CompoundNBT();
			tags.putInt("Damage", 0);
			output.setTag(tags);
			event.setOutput(output);
			event.setMaterialCost(equipmentUpgrade.materialAmount);

			int minCost = ModList.get().isLoaded("charm") ? 0 : 1;

			int cost = minCost;

			Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(left);
			for (Enchantment enchantment : enchantments.keySet()) {
				int lvl = enchantments.get(enchantment);
				int baseCost = 0;
				switch (enchantment.getRarity()) {
					case COMMON:
						baseCost = 1;
						break;
					case UNCOMMON:
						baseCost = 2;
						break;
					case RARE:
						baseCost = 4;
						break;
					case VERY_RARE:
						baseCost = 8;
				}
				cost += baseCost * lvl;
			}
			cost *= 0.667f;

			event.setCost(MathHelper.clamp(cost, minCost, 39));
		}
	}

	public static class EquipmentUpgrade {
		public Item inputItem;
		public int materialAmount;

		public EquipmentUpgrade(Item inputItem, int materialAmount) {
			this.inputItem = inputItem;
			this.materialAmount = materialAmount;
		}
	}
}
