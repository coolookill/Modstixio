package com.soloerio.modstixio;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.item.v1.ItemComponentTooltipProviderRegistry;
import net.minecraft.core.component.DataComponents;
import com.soloerio.modstixio.components.modcomponents;

public class modstixioClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // 关键：将你的复合组件注册到工具提示提供器系统
        ItemComponentTooltipProviderRegistry.addAfter(
                DataComponents.DAMAGE,
                modcomponents.COMPONENT_WITH_TOOLTIP
        );
        System.out.println("[modstixio] COMPONENT_WITH_TOOLTIP tooltip provider registered");
    }
}