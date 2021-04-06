package net.mcreator.blahmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;

import net.mcreator.blahmod.block.WhitewoodLeavesBlock;
import net.mcreator.blahmod.block.TropicsLeavesBlock;
import net.mcreator.blahmod.block.FrostWoodLeavesBlock;
import net.mcreator.blahmod.block.DreadLeavesBlock;
import net.mcreator.blahmod.block.DarkMatterSmallBushBlock;
import net.mcreator.blahmod.block.DarkMatterLeavesBlock;
import net.mcreator.blahmod.block.DarkMatterBushBlock;
import net.mcreator.blahmod.block.CedarLeavesBlock;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class ScytheClickedProcedure extends BlahmodModElements.ModElement {
	public ScytheClickedProcedure(BlahmodModElements instance) {
		super(instance, 1400);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ScytheClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ScytheClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ScytheClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ScytheClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.GRASS.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DEAD_BUSH.getDefaultState().getBlock()))
				|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.GRASS.getDefaultState().getBlock())
						|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.FERN.getDefaultState().getBlock())))
				|| (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.TALL_GRASS.getDefaultState().getBlock())
						|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.SEAGRASS.getDefaultState()
								.getBlock()))
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == DarkMatterBushBlock.block.getDefaultState()
								.getBlock())
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == DarkMatterSmallBushBlock.block
										.getDefaultState().getBlock())))
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.TALL_SEAGRASS.getDefaultState()
								.getBlock())
								|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OAK_LEAVES.getDefaultState()
										.getBlock())
										|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.SPRUCE_LEAVES
												.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.BIRCH_LEAVES
														.getDefaultState().getBlock())
														|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
																.getBlock() == Blocks.JUNGLE_LEAVES.getDefaultState().getBlock())
																|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
																		.getBlock() == Blocks.ACACIA_LEAVES.getDefaultState().getBlock())
																		|| (((world.getBlockState(new BlockPos((int)x, (int)y, (int)z))).getBlock() instanceof LeavesBlock)) ||
																			(((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
																				.getBlock() == Blocks.DARK_OAK_LEAVES.getDefaultState().getBlock())
																				|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
																						.getBlock() == TropicsLeavesBlock.block.getDefaultState()
																								.getBlock())
																						|| (((world.getBlockState(
																								new BlockPos((int) x, (int) y, (int) z)))
																										.getBlock() == CedarLeavesBlock.block
																												.getDefaultState().getBlock())
																								|| (((world.getBlockState(
																										new BlockPos((int) x, (int) y, (int) z)))
																												.getBlock() == FrostWoodLeavesBlock.block
																														.getDefaultState().getBlock())
																										|| (((world.getBlockState(new BlockPos(
																												(int) x, (int) y, (int) z)))
																														.getBlock() == DarkMatterLeavesBlock.block
																																.getDefaultState()
																																.getBlock())
																												|| (((world.getBlockState(
																														new BlockPos((int) x, (int) y,
																																(int) z)))
																																		.getBlock() == WhitewoodLeavesBlock.block
																																				.getDefaultState()
																																				.getBlock())
																														|| ((world.getBlockState(
																																new BlockPos((int) x,
																																		(int) y,
																																		(int) z)))
																																				.getBlock() == DreadLeavesBlock.block
																																						.getDefaultState()
																																						.getBlock())))))))))))))))) {
			sx = (double) (-5);
			for (int index0 = 0; index0 < (int) (10); index0++) {
				sy = (double) (-5);
				for (int index1 = 0; index1 < (int) (10); index1++) {
					sz = (double) (-5);
					for (int index2 = 0; index2 < (int) (10); index2++) {
						if ((((((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))))).getBlock() == Blocks.GRASS
								.getDefaultState().getBlock())
								|| ((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
										.getBlock() == Blocks.DEAD_BUSH.getDefaultState().getBlock()))
								|| (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
										.getBlock() == Blocks.GRASS.getDefaultState().getBlock())
										|| ((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock() == Blocks.FERN.getDefaultState().getBlock())))
								|| ((((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
										.getBlock() == Blocks.TALL_GRASS.getDefaultState().getBlock())
										|| ((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock() == Blocks.SEAGRASS.getDefaultState().getBlock()))
										|| (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock() == DarkMatterBushBlock.block.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
														.getBlock() == DarkMatterSmallBushBlock.block.getDefaultState().getBlock())
														|| (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
																.getBlock() == Blocks.TALL_SEAGRASS.getDefaultState().getBlock())
																|| (((world.getBlockState(
																		new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
																				.getBlock() == Blocks.OAK_LEAVES.getDefaultState().getBlock())
																		|| (((world.getBlockState(
																				new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
																						.getBlock() == Blocks.SPRUCE_LEAVES.getDefaultState()
																								.getBlock())
																				|| (((world.getBlockState(new BlockPos((int) (x + (sx)),
																						(int) (y + (sy)), (int) (z + (sz)))))
																								.getBlock() == Blocks.BIRCH_LEAVES.getDefaultState()
																										.getBlock())
																						|| (((world.getBlockState(new BlockPos((int) (x + (sx)),
																								(int) (y + (sy)), (int) (z + (sz)))))
																										.getBlock() == Blocks.JUNGLE_LEAVES
																												.getDefaultState().getBlock())
																								|| (((world.getBlockState(new BlockPos(
																										(int) (x + (sx)), (int) (y + (sy)),
																										(int) (z + (sz)))))
																												.getBlock() == Blocks.ACACIA_LEAVES
																														.getDefaultState().getBlock())
																										|| (((world.getBlockState(new BlockPos(
																												(int) (x + (sx)), (int) (y + (sy)),
																												(int) (z + (sz)))))
																														.getBlock() == Blocks.DARK_OAK_LEAVES
																																.getDefaultState()
																																.getBlock())
																												|| (((world.getBlockState(
																														new BlockPos((int) (x + (sx)),
																																(int) (y + (sy)),
																																(int) (z + (sz)))))
																																		.getBlock() == TropicsLeavesBlock.block
																																				.getDefaultState()
																																				.getBlock())
																														|| (((world.getBlockState(
																																new BlockPos((int) (x
																																		+ (sx)),
																																		(int) (y + (sy)),
																																		(int) (z + (sz)))))
																																				.getBlock() == CedarLeavesBlock.block
																																						.getDefaultState()
																																						.getBlock())
																																|| (((world
																																		.getBlockState(
																																				new BlockPos(
																																						(int) (x + (sx)),
																																						(int) (y + (sy)),
																																						(int) (z + (sz)))))
																																								.getBlock() == FrostWoodLeavesBlock.block
																																										.getDefaultState()
																																										.getBlock())
																																		|| (((world
																																				.getBlockState(
																																						new BlockPos(
																																								(int) (x + (sx)),
																																								(int) (y + (sy)),
																																								(int) (z + (sz)))))
																																										.getBlock() == DarkMatterLeavesBlock.block
																																												.getDefaultState()
																																												.getBlock())
																																				|| (((world
																																						.getBlockState(
																																								new BlockPos(
																																										(int) (x + (sx)),
																																										(int) (y + (sy)),
																																										(int) (z + (sz)))))
																																												.getBlock() == WhitewoodLeavesBlock.block
																																														.getDefaultState()
																																														.getBlock())
																																				|| (((world
																																						.getBlockState(
																																								new BlockPos(
																																										(int) (x + (sx)),
																																										(int) (y + (sy)),
																																										(int) (z + (sz)))))
																																												.getBlock() instanceof LeavesBlock))

																																						|| ((world
																																								.getBlockState(
																																										new BlockPos(
																																												(int) (x + (sx)),
																																												(int) (y + (sy)),
																																												(int) (z + (sz)))))
																																														.getBlock() == DreadLeavesBlock.block
																																																.getDefaultState()
																																																.getBlock())))))))))))))))))) {
							world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
		}
	}
}
