package insane96mcp.carbonado.item.material;

import insane96mcp.carbonado.setup.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class ModMaterial {
	public static final IItemTier TOOLS_CARBONADO = new IItemTier() {

		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromItems(ModItems.CARBONADO.get());
		}

		@Override
		public int getMaxUses() {
			return 2601;
		}

		@Override
		public int getHarvestLevel() {
			return 4;
		}

		@Override
		public int getEnchantability() {
			return 13;
		}

		@Override
		public float getEfficiency() {
			return 11;
		}

		@Override
		public float getAttackDamage() {
			return 4f;
		}
	};

	public static final IArmorMaterial ARMOR_CARBONADO = new IArmorMaterial() {

		@Override
		public float getToughness() {
			return 2f;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromItems(ModItems.CARBONADO.get());
		}

		@Override
		public String getName() {
			return "carbonado:carbonado";
		}

		@Override
		public int getEnchantability() {
			return 13;
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			switch (slotIn) {
				case HEAD:
					return 605;

				case CHEST:
					return 880;

				case LEGS:
					return 825;

				case FEET:
					return 715;

				default:
					return 0;
			}
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			switch (slotIn) {
				case HEAD:
					return 5;

				case CHEST:
					return 8;

				case LEGS:
					return 7;

				case FEET:
					return 4;

				default:
					return 0;
			}
		}
	};
}
