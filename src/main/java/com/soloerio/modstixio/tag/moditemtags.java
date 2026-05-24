package com.soloerio.modstixio.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class moditemtags {
    public static final TagKey<Item> REDSTIX_TOOL_MATERIALS = bind("redstix_tool_materials");
    public static final TagKey<Item> REINFORCED_REDSTIX_TOOL_MATERIALS = bind("reinforced_redstix_tool_materials");

    private static TagKey<Item> bind(final String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("modstixio", name));
    }
}
