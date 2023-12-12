package dev.squiggles.effect;

import dev.squiggles.WingedBoots;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class StatusEffects {

    public static final FloatStatusEffect FLOATING = new FloatStatusEffect();

    public static void registerEffects() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(WingedBoots.MODID, "float"), FLOATING);
    }
}
