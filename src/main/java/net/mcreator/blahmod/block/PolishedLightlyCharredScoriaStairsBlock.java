
package net.mcreator.blahmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.blahmod.itemgroup.CreativeTabBlahBlocksItemGroup;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.List;
import java.util.Collections;

@BlahmodModElements.ModElement.Tag
public class PolishedLightlyCharredScoriaStairsBlock extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:polished_lightly_charred_scoria_stairs")
	public static final Block block = null;
	public PolishedLightlyCharredScoriaStairsBlock(BlahmodModElements instance) {
		super(instance, 1584);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(CreativeTabBlahBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6f)).getDefaultState(),
					Block.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1.5f, 6f).setLightLevel(s -> 0)
							.harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("polished_lightly_charred_scoria_stairs");
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
