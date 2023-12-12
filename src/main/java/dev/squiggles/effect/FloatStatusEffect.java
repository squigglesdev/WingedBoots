package dev.squiggles.effect;


import org.joml.Math;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FloatStatusEffect extends StatusEffect{

    public FloatStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xacc3d9);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(net.minecraft.entity.LivingEntity entity, int amplifier) {
        if (!entity.isOnGround() && !entity.isSneaking()) {
            entity.setVelocity(entity.getVelocity().x, Math.max(0, Math.min(0.42, entity.getVelocity().y)), entity.getVelocity().z);
        }
        if (!entity.isSneaking()) {
            entity.fallDistance = 0;
        }
    }

}
