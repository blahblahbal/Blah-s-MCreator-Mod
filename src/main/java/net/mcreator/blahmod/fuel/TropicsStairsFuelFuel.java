
package net.mcreator.blahmod.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.blahmod.block.TropicsStairsBlock;
import net.mcreator.blahmod.BlahmodModElements;

@BlahmodModElements.ModElement.Tag
public class TropicsStairsFuelFuel extends BlahmodModElements.ModElement {
	public TropicsStairsFuelFuel(BlahmodModElements instance) {
		super(instance, 722);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(TropicsStairsBlock.block, (int) (1)).getItem())
			event.setBurnTime(300);
	}
}
