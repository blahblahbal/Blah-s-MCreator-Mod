
package net.mcreator.blahmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.blahmod.itemgroup.CreativeTabBlahItemsItemGroup;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.List;

@BlahmodModElements.ModElement.Tag
public class ObsidianPickaxeItem extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:obsidian_pickaxe")
	public static final Item block = null;
	public ObsidianPickaxeItem(BlahmodModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 50;
			}

			public float getEfficiency() {
				return 11f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 17;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ObsidianIngotItem.block, (int) (1)));
			}
		}, 1, -2.8f, new Item.Properties().group(CreativeTabBlahItemsItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\uFFFD7Fragile"));
			}
		}.setRegistryName("obsidian_pickaxe"));
	}
}
