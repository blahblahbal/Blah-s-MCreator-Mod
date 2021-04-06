
package net.mcreator.blahmod.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.blahmod.block.DarkMatterLogBlock;
import net.mcreator.blahmod.BlahmodModElements;

@BlahmodModElements.ModElement.Tag
public class DMLogFuelFuel extends BlahmodModElements.ModElement {
	public DMLogFuelFuel(BlahmodModElements instance) {
		super(instance, 1195);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(DarkMatterLogBlock.block, (int) (1)).getItem())
			event.setBurnTime(300);
	}
}
