package net.mcreator.blahmod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.item.ExperienceOrbEntity;

import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class SulphurOreXPProcedure extends BlahmodModElements.ModElement {
	public SulphurOreXPProcedure(BlahmodModElements instance) {
		super(instance, 891);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure SulphurOreXP!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure SulphurOreXP!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure SulphurOreXP!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure SulphurOreXP!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.isRemote()) {
			((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 4));
		}
		if (world instanceof World && !world.isRemote()) {
			((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 3));
		}
		if (world instanceof World && !world.isRemote()) {
			((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 3));
		}
	}
}
