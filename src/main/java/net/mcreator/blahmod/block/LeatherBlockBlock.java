
package net.mcreator.blahmod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.blahmod.itemgroup.CreativeTabBlahBlocksItemGroup;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.List;
import java.util.Collections;

@BlahmodModElements.ModElement.Tag
public class LeatherBlockBlock extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:leather_block")
	public static final Block block = null;
	public LeatherBlockBlock(BlahmodModElements instance) {
		super(instance, 247);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(CreativeTabBlahBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOL).sound(SoundType.CLOTH).hardnessAndResistance(0.9f, 0.8f).setLightLevel(s -> 0));
			setRegistryName("leather_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
