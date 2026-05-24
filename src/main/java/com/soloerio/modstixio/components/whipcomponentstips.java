package com.soloerio.modstixio.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public record whipcomponentstips(Float pull_rate, Float pull_strength, Float pull_cooldown) implements TooltipProvider {

    public static final Codec<whipcomponentstips> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("pull_rate").forGetter(whipcomponentstips::pull_rate),
            Codec.FLOAT.fieldOf("pull_strength").forGetter(whipcomponentstips::pull_strength),
            Codec.FLOAT.fieldOf("pull_cooldown").forGetter(whipcomponentstips::pull_cooldown)
    ).apply(instance, whipcomponentstips::new));

    @Override
    public void addToTooltip(Item.@NonNull TooltipContext context, Consumer<Component> consumer, @NonNull TooltipFlag flag, @NonNull DataComponentGetter components) {
        consumer.accept(Component.empty());

        consumer.accept(Component.translatable("item.modstixio.pull_rate.info", this.pull_rate)
                .withStyle(style -> style.withColor(TextColor.fromRgb(0x83BBF2))));
        consumer.accept(Component.translatable("item.modstixio.pull_strength.info", this.pull_strength)
                .withStyle(style -> style.withColor(TextColor.fromRgb(0x83BBF2))));
        consumer.accept(Component.translatable("item.modstixio.pull_cooldown.info", this.pull_cooldown)
                .withStyle(style -> style.withColor(TextColor.fromRgb(0xB79CE6))));
    }

    public static void registermodstixwhip() {
        System.out.println("[modstixio] Whip components group registered");
    }
}