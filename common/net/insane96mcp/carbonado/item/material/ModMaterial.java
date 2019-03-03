package net.insane96mcp.carbonado.item.material;

import net.insane96mcp.carbonado.init.ModItems;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;

public class ModMaterial {
	public static final IItemTier TOOLS_CARBONADO = new IItemTier() {
		
		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromItems(ModItems.carbonado);
		}
		
		@Override
		public int getMaxUses() {
			return 2341;
		}
		
		@Override
		public int getHarvestLevel() {
			return 4;
		}
		
		@Override
		public int getEnchantability() {
			return 12;
		}
		
		@Override
		public float getEfficiency() {
			return 12;
		}
		
		@Override
		public float getAttackDamage() {
			return 4f;
		}
	};

	public static final IArmorMaterial ARMOR_CARBONADO = new IArmorMaterial() {
		
		@Override
		public float getToughness() {
			return 3f;
		}
		
		@Override
		public SoundEvent getSoundEvent() {
			return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
		}
		
		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromItems(ModItems.carbonado);
		}
		
		@Override
		public String getName() {
			return "carbonado:carbonado";
		}
		
		@Override
		public int getEnchantability() {
			return 12;
		}
		
		@Override
		public int getDurability(EntityEquipmentSlot slotIn) {
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
		
		@Override
		public int getDamageReductionAmount(EntityEquipmentSlot slotIn) {
			switch (slotIn) {
			case HEAD:
				return 545;

			case CHEST:
				return 792;
				
			case LEGS:
				return 743;

			case FEET:
				return 644;

			default:
				return 0;
			}
		}
	};
	//public static ArmorMaterial Armor = EnumHelper.addArmorMaterial(50);
}
