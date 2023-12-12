package dev.squiggles.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.item.Items;


public class HoverArmorMaterial implements ArmorMaterial {
    public static final int[] BASE_DURABILITY = new int[] { 13, 15, 16, 11 };
    public static final int[] PROTECTION_VALUES = new int[] { 3, 6, 8, 3 };
    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[0] * 9;
    }
    @Override
    public int getProtection(ArmorItem.Type type) {
        return PROTECTION_VALUES[0];
    }
    @Override
    public int getEnchantability() {
        return 15;
    }
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }
    @Override
    public String getName() {
        return "hover";
    }
    @Override
    public float getToughness() {
        return 1.0f;
    }
    @Override
    public float getKnockbackResistance() {
        return 0.0f;
    }
}


