package com.soloerio.modstixio.item;

import com.soloerio.modstixio.tag.moditemtags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public class modtoolmaterials {
    public static final ToolMaterial REDSTIX = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,384, 5.0F, 0.0F, 8, moditemtags.REDSTIX_TOOL_MATERIALS
    );
    public static final ToolMaterial REINFORCED_REDSTIX = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,512, 6.0F, 0.0F, 16, moditemtags.REINFORCED_REDSTIX_TOOL_MATERIALS
    );
}
