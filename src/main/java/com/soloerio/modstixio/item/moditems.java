package com.soloerio.modstixio.item;

import com.soloerio.modstixio.components.modcomponents;
import com.soloerio.modstixio.components.whipcomponentstips;
import com.soloerio.modstixio.item.custom.revknockback;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class moditems {

    private static Item registerItem(final String name, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("modstixio",name));
        Item item = (Item)itemFactory.apply(properties.setId(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }
        return (Item) Registry.register(BuiltInRegistries.ITEM, key, item);
    }
    private static Item registerItem(final String name, final Function<Item.Properties, Item> itemFactory) {
        return (Item) registerItem(name, itemFactory, new Item.Properties());
    }
    private static Item registerItem(final String name) {
        return (Item) registerItem(name, Item::new , new Item.Properties());
    }
    public static void registemodstixitems() {}
    //ok now we can register items
    //caution lang items models.item

    public static final Item TONGSTONE_FRAGMENT = registerItem("tongstone_fragment");
    public static final Item REDSTIX_CORE = registerItem("redstix_core");
    public static final Item REDSTIX_WHIP = registerItem("redstix_whip", revknockback::new,
            new Item.Properties().sword(modtoolmaterials.REDSTIX, 1.0F, -3.2F)
                    .component(modcomponents.COMPONENT_WITH_TOOLTIP, new whipcomponentstips(30F, 0.2F, 10.0F)));
    public static final Item REDSTIX_COIL = registerItem("redstix_coil");
    public static final Item COMPRESSED_REDSTIX_CORE = registerItem("compressed_redstix_core");
    public static final Item REINFORCED_REDSTIX_WHIP = registerItem("reinforced_redstix_whip",
            revknockback::new, new Item.Properties().sword(modtoolmaterials.REINFORCED_REDSTIX, 3.0F, -3F)
                    .component(modcomponents.COMPONENT_WITH_TOOLTIP, new whipcomponentstips(60F, 0.5F, 5.0F)));

}