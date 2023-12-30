package dev.squiggles.item;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import dev.squiggles.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HoverBootsItem extends ArmorItem{
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(Items.HOVER_ARMOR_MATERIAL, new StatusEffectInstance(StatusEffects.FLOATING, 5, 255, false, false, false)).build();

    public HoverBootsItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player && hasBootsOn(player)) {
                evaluateEffect(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasBootsOn(PlayerEntity player) {
        ItemStack boots =  player.getInventory().getArmorStack(0);

        return !boots.isEmpty();
    }

    private void evaluateEffect(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial material = entry.getKey();
            StatusEffectInstance effect = entry.getValue();

            if(hasCorrectArmorOn(material, player)) {
                addStatusEffect(player, material, effect);
            }
        }
    }

    private void addStatusEffect(PlayerEntity player, ArmorMaterial material, StatusEffectInstance effect) {
        if(hasCorrectArmorOn(material, player)) {
            player.addStatusEffect(new StatusEffectInstance(effect));
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {

        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();

        return boots.getMaterial() == material;
    }

}
