
package net.mcreator.blahmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.blahmod.procedures.ScytheClickedProcedure;
import net.mcreator.blahmod.itemgroup.CreativeTabBlahItemsItemGroup;
import net.mcreator.blahmod.block.DarkMatterSmallBushBlock;
import net.mcreator.blahmod.block.DarkMatterBushBlock;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

@BlahmodModElements.ModElement.Tag
public class TadaniteScytheItem extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:tadanite_scythe")
	public static final Item block = null;
	public TadaniteScytheItem(BlahmodModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A7eEfficient"));
			}

			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, BlockState bl, BlockPos pos, LivingEntity entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, bl, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					ScytheClickedProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("tadanite_scythe"));
	}
	private static class ItemToolCustom extends Item {
		protected ItemToolCustom() {
			super(new Item.Properties().group(CreativeTabBlahItemsItemGroup.tab).maxDamage(4000));
		}

		@Override
		public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
			if (blockstate.getBlock() == Blocks.GRASS.getDefaultState().getBlock())
				return 14f;
			if (blockstate.getBlock() == Blocks.DEAD_BUSH.getDefaultState().getBlock())
				return 14f;
			if (blockstate.getBlock() == Blocks.GRASS.getDefaultState().getBlock())
				return 14f;
			if (blockstate.getBlock() == Blocks.FERN.getDefaultState().getBlock())
				return 14f;
			if (blockstate.getBlock() == Blocks.TALL_GRASS.getDefaultState().getBlock())
				return 14f;
			if (blockstate.getBlock() == Blocks.TALL_SEAGRASS.getDefaultState().getBlock())
				return 14f;
			if (blockstate.getBlock() == DarkMatterBushBlock.block.getDefaultState().getBlock())
				return 14f;
			if (blockstate.getBlock() == DarkMatterSmallBushBlock.block.getDefaultState().getBlock())
				return 14f;
			return 1;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
			stack.damageItem(1, entityLiving, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			stack.damageItem(2, attacker, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 20;
		}

		@Override
		public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
			if (equipmentSlot == EquipmentSlotType.MAINHAND) {
				ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
				builder.putAll(super.getAttributeModifiers(equipmentSlot));
				builder.put(Attributes.ATTACK_DAMAGE,
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", -1f, AttributeModifier.Operation.ADDITION));
				builder.put(Attributes.ATTACK_SPEED,
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -3, AttributeModifier.Operation.ADDITION));
				return builder.build();
			}
			return super.getAttributeModifiers(equipmentSlot);
		}
	}
}
