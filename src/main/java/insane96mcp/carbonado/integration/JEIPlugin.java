package insane96mcp.carbonado.integration;

import insane96mcp.carbonado.Carbonado;
import insane96mcp.carbonado.event.AnvilUpdate;
import insane96mcp.carbonado.setup.ModItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

	private static final ResourceLocation UID = new ResourceLocation(Carbonado.MOD_ID, Carbonado.MOD_ID);

	@Override
	public ResourceLocation getPluginUid() {
		return UID;
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		final IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();

		registerVulcaniteToolForging(registration, factory);

		IIngredientManager ingredientManager = registration.getIngredientManager();
		IIngredientType<ItemStack> type = ingredientManager.getIngredientType(ItemStack.class);

		registration.addIngredientInfo(new ItemStack(ModItems.CARBONADO.get()), type, "Check Advancements");
		registration.addIngredientInfo(new ItemStack(ModItems.CARBONADO_ORE.get()), type, "Check Advancements");
		registration.addIngredientInfo(new ItemStack(ModItems.CARBONADO_SHARD.get()), type, "Check Advancements");
	}

	private void registerVulcaniteToolForging(IRecipeRegistration registration, IVanillaRecipeFactory factory) {
		List<Object> recipes = new ArrayList<>();
		for (AnvilUpdate.EquipmentUpgrade upgrade : AnvilUpdate.EQUIPMENT_UPGRADES) {
			ItemStack equipment = new ItemStack(upgrade.inputItem);
			ItemStack carbonado = new ItemStack(ModItems.CARBONADO.get(), upgrade.materialAmount);
			String itemName = upgrade.inputItem.getRegistryName().getPath();
			ResourceLocation vulcaniteName = new ResourceLocation(Carbonado.MOD_ID, itemName.replace("diamond", "carbonado"));
			ItemStack output = new ItemStack(ForgeRegistries.ITEMS.getValue(vulcaniteName));

			recipes.add(factory.createAnvilRecipe(equipment,
					Collections.singletonList(carbonado),
					Collections.singletonList(output)
			));
		}

		registration.addRecipes(recipes, VanillaRecipeCategoryUid.ANVIL);
	}
}