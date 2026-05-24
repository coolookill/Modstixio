package com.soloerio.modstixio;

import com.soloerio.modstixio.block.modblocks;
import com.soloerio.modstixio.components.modcomponents;
import com.soloerio.modstixio.components.whipcomponentstips;
import com.soloerio.modstixio.item.modinventory;
import com.soloerio.modstixio.item.moditems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Modstixio implements ModInitializer {
	public static final String MOD_ID = "modstixio";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		moditems.registemodstixitems();
		modblocks.registermodstixblocks();
		modinventory.registermodstixtabs();
		whipcomponentstips.registermodstixwhip();
		modcomponents.registermodcompo();
		LOGGER.info("ok");
	}
}