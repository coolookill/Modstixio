package com.soloerio.modstixio.item;

import com.soloerio.modstixio.block.modblocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class modinventory {
    public static final ResourceKey<CreativeModeTab> MODSTIX_TAB = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath("modstixio", "modstix")
    );
    public static final CreativeModeTab MODSTIX = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(moditems.TONGSTONE_FRAGMENT))
            .title(Component.translatable("itemGroup.modstix"))
            .displayItems((parameters, output) -> {
                //ok now we can add items into the tab
                output.accept(moditems.TONGSTONE_FRAGMENT);
                output.accept(modblocks.TONGSTONE);
                output.accept(moditems.REDSTIX_CORE);
                output.accept(moditems.COMPRESSED_REDSTIX_CORE);
                output.accept(moditems.REDSTIX_COIL);
                output.accept(moditems.REDSTIX_WHIP);
                output.accept(moditems.REINFORCED_REDSTIX_WHIP);


            }).build();
    public static void registermodstixtabs() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MODSTIX_TAB, MODSTIX);
    }
}
