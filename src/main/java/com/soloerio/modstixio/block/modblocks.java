package com.soloerio.modstixio.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class modblocks {
    public static Block register(final String name, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        ResourceKey<Block> id = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("modstixio", name));
        Block block = (Block)factory.apply(properties.setId(id));
        registerblocktoitem(name, block);
        return (Block) Registry.register(BuiltInRegistries.BLOCK, id, block);
    }
    public static Block register(final String name, final BlockBehaviour.Properties properties) {
        return register(name, Block::new, properties);
    }
    private static void registerblocktoitem(String name, Block block) {
        ResourceKey<Item> id = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("modstixio", name));
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(id).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, id, blockItem);
    }
    public static void registermodstixblocks() {

    }
    //ok now we can register blocks

    public static final Block TONGSTONE = register("tongstone",
            BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().
                    strength(2.0F, 6.0F).noOcclusion()
    );
}
