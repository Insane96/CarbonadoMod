package net.insane96mcp.carbonado.item;

import java.util.List;

import javax.annotation.Nullable;

import net.insane96mcp.carbonado.init.Strings.Tooltips;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ItemCarbonado extends Item {
	
	public ItemCarbonado(String id) {
		super(new Properties().group(ItemGroup.MATERIALS));
		
		setRegistryName(id);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation(Tooltips.Gem.blackDiamond));
	}
}
