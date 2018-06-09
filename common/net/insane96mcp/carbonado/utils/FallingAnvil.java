package net.insane96mcp.carbonado.utils;

import net.minecraft.entity.item.EntityFallingBlock;

public class FallingAnvil {
	public EntityFallingBlock fallingBlock;
	public double originalY;
	
	public FallingAnvil(EntityFallingBlock fallingBlock, double originalY) {
		this.fallingBlock = fallingBlock;
		this.originalY = originalY;
	}
}
