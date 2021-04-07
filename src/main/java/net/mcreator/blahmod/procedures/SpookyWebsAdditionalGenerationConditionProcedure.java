package net.mcreator.blahmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class SpookyWebsAdditionalGenerationConditionProcedure extends BlahmodModElements.ModElement {
	public SpookyWebsAdditionalGenerationConditionProcedure(BlahmodModElements instance) {
		super(instance, 1724);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure SpookyWebsAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure SpookyWebsAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure SpookyWebsAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure SpookyWebsAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((!(((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())))) {
			return (true);
		}
		return (false);
	}
}
