package com.soloerio.modstixio.item.custom;

import com.soloerio.modstixio.components.modcomponents;
import com.soloerio.modstixio.components.whipcomponentstips;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class revknockback extends Item {
    public revknockback(Properties properties) {
        super(properties);
    }

    @Override
    public void hurtEnemy(@NonNull ItemStack itemStack, @NonNull LivingEntity mob, LivingEntity attacker) {
        if(!attacker.level().isClientSide()) {
            if(attacker instanceof Player player) {
                float random = RandomSource.create().nextFloat();
                whipcomponentstips compo = itemStack.get(modcomponents.COMPONENT_WITH_TOOLTIP);
                assert compo != null;
                float rate = compo.pull_rate()/100;
                Float strength = compo.pull_strength();
                Float cd = compo.pull_cooldown();
                if(player.getCooldowns().isOnCooldown(itemStack)) {
                    return;
                }
                if(random <= rate) {
                    double dx = attacker.getX() - mob.getX();
                    double dz = attacker.getZ() - mob.getZ();
                    double dist = Math.sqrt(dx * dx + dz * dz);
                    if (dist > 0) {
                        dx /= dist;
                        dz /= dist;
                    }
                    double upkb = 0.32;
                    mob.setDeltaMovement(dx * strength, upkb, dz * strength);
                    mob.hurtMarked = true;
                    itemStack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND); // -2 durability when affect
                }
                player.getCooldowns().addCooldown(itemStack, (int)Math.floor(cd*19.2)); // though 20ticks/s but we still multiply 19.2
            }
        }
    }


}
