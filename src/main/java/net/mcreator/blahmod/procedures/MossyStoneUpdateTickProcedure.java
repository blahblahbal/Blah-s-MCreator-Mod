package net.mcreator.blahmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class MossyStoneUpdateTickProcedure extends BlahmodModElements.ModElement {
	public MossyStoneUpdateTickProcedure(BlahmodModElements instance) {
		super(instance, 1656);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure MossyStoneUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure MossyStoneUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure MossyStoneUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure MossyStoneUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))).getBlock() instanceof IWaterLoggable) || (((world
				.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.LEAVES)
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
						.getMaterial() == net.minecraft.block.material.Material.PLANTS)
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.TALL_PLANTS)
								|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
										.getMaterial() == net.minecraft.block.material.Material.AIR)
										|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.TORCH
												.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
														.getBlock() == Blocks.WALL_TORCH.getDefaultState().getBlock())
														|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
																.getBlock() == Blocks.SOUL_TORCH.getDefaultState().getBlock())
																|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
																		.getBlock() == Blocks.SOUL_WALL_TORCH.getDefaultState().getBlock())
																		|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
																				.getBlock() == Blocks.REDSTONE_TORCH.getDefaultState().getBlock())
																				|| (((world
																						.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
																								.getBlock() == Blocks.REDSTONE_WALL_TORCH
																										.getDefaultState().getBlock())
																						|| ((world.getBlockState(
																								new BlockPos((int) x, (int) (y + 1), (int) z)))
																										.getBlock() == Blocks.REDSTONE_TORCH
																												.getDefaultState()
																												.getBlock())))))))))))))) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = Blocks.STONE.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
