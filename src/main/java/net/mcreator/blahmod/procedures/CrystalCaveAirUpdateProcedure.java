package net.mcreator.blahmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.Blocks;

import net.mcreator.blahmod.block.XenonCrystalOreBlock;
import net.mcreator.blahmod.block.XenonCrystalClusterBlock;
import net.mcreator.blahmod.block.NeonCrystalOreBlock;
import net.mcreator.blahmod.block.NeonCrystalClusterBlock;
import net.mcreator.blahmod.block.KryptonCrystalOreBlock;
import net.mcreator.blahmod.block.KryptonCrystalClusterBlock;
import net.mcreator.blahmod.block.ArgonCrystalOreBlock;
import net.mcreator.blahmod.block.ArgonCrystalClusterBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class CrystalCaveAirUpdateProcedure extends BlahmodModElements.ModElement {
	public CrystalCaveAirUpdateProcedure(BlahmodModElements instance) {
		super(instance, 1733);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure CrystalCaveAirUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure CrystalCaveAirUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure CrystalCaveAirUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure CrystalCaveAirUpdate!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
				if ((Math.random() < 0.95)) {
					if ((Math.random() < 0.33)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ArgonCrystalClusterBlock.block.getDefaultState(), 3);
					}
					if ((Math.random() < 0.33)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), KryptonCrystalClusterBlock.block.getDefaultState(), 3);
					}
					if ((Math.random() < 0.33)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), NeonCrystalClusterBlock.block.getDefaultState(), 3);
					}
					if ((Math.random() < 0.33)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), XenonCrystalClusterBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)) {
				if ((!(((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z)))).getBlock() instanceof IWaterLoggable))) {
					if ((Math.random() < 0.02)) {
						if ((Math.random() < 0.75)) {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), ArgonCrystalOreBlock.block.getDefaultState(), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), KryptonCrystalOreBlock.block.getDefaultState(), 3);
						}
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)) {
				if ((!(((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z)))).getBlock() instanceof IWaterLoggable))) {
					if ((Math.random() < 0.02)) {
						if ((Math.random() < 0.75)) {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), NeonCrystalOreBlock.block.getDefaultState(), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), XenonCrystalOreBlock.block.getDefaultState(), 3);
						}
					}
				}
			}
		}
	}
}
