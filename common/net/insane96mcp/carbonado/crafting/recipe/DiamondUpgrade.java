package net.insane96mcp.carbonado.crafting.recipe;

import com.google.gson.JsonObject;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.CraftingHelper.ShapedPrimer;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class DiamondUpgrade extends ShapedOreRecipe {

	public DiamondUpgrade(ResourceLocation group, ItemStack result, ShapedPrimer primer) {
		super(group, result, primer);
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		final ItemStack output = super.getCraftingResult(inv);
		
		if (!output.isEmpty()) {
			for (int i = 0; i < inv.getSizeInventory(); i++) {
				final ItemStack ingredient = inv.getStackInSlot(i);

				if (!ingredient.isEmpty() && (ingredient.getItem() instanceof ItemArmor || ingredient.getItem() instanceof ItemTool)) {
					final NBTTagCompound tags = ingredient.getTagCompound();
					output.setTagCompound(tags);
					break;
				}
			}
		}
		
		return output;
	}

	public static class Factory implements IRecipeFactory{

		@Override
		public IRecipe parse(JsonContext context, JsonObject json) {
			final String group = JsonUtils.getString(json, "group", "");
			final CraftingHelper.ShapedPrimer primer = RecipeUtil.parseShaped(context, json);
			final ItemStack result = CraftingHelper.getItemStack(JsonUtils.getJsonObject(json, "result"), context);

			return new DiamondUpgrade(group.isEmpty() ? null : new ResourceLocation(group), result, primer);
		}
		
	}
}
