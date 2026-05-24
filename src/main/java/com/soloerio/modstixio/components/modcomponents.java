package com.soloerio.modstixio.components;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class modcomponents {
    public static final DataComponentType<Float> PULL_RATE =
            Registry.register(
                    BuiltInRegistries.DATA_COMPONENT_TYPE,
                    Identifier.fromNamespaceAndPath("modstixio", "pull_rate"),
                    DataComponentType.<Float>builder().persistent(Codec.FLOAT).build()
            );

    public static final DataComponentType<Float> PULL_STRENGTH =
            Registry.register(
                    BuiltInRegistries.DATA_COMPONENT_TYPE,
                    Identifier.fromNamespaceAndPath("modstixio", "pull_strength"),
                    DataComponentType.<Float>builder().persistent(Codec.FLOAT).build()
            );

    public static final DataComponentType<Float> PULL_COOLDOWN =
            Registry.register(
                    BuiltInRegistries.DATA_COMPONENT_TYPE,
                    Identifier.fromNamespaceAndPath("modstixio", "pull_cooldown"),
                    DataComponentType.<Float>builder().persistent(Codec.FLOAT).build()
            );

    public static final DataComponentType<whipcomponentstips> COMPONENT_WITH_TOOLTIP = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath("modstixio", "whip_tooltip"),
            DataComponentType.<whipcomponentstips>builder().persistent(whipcomponentstips.CODEC).build()
    );



    public static void registermodcompo() {
        System.out.println("[modstixio] All mod compo registered");
    }
}
