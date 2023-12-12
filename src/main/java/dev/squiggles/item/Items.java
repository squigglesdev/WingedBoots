package dev.squiggles.item;

import dev.squiggles.WingedBoots;
import dev.squiggles.armor.HoverArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class Items {

    public static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new Identifier("item/empty_armor_slot_boots");
    public static final Identifier EMPTY_SLOT_FEATHER_TEXTURE = new Identifier("wingedboots:item/empty_slot_feather");

    public static final ArmorMaterial HOVER_ARMOR_MATERIAL = new HoverArmorMaterial();

    public static final Item HOVER_BOOTS = new HoverBootsItem(HOVER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item HOVER_TEMPLATE = new SmithingTemplateItem(Text.of("§9Netherite Boots"), Text.of("§9Feathers"), Text.of("§7Winged Boots Trim"), Text.of("Add Boots"), Text.of("Add Feathers"), getArmorTrimEmptyBaseSlotTextures(), getArmorTrimEmptyAdditionSlotTextures());

    public static final Item CLOUD_BOTTLE = new Item(new Item.Settings());
    private static List<Identifier> getArmorTrimEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_BOOTS_TEXTURE);
    }

    private static List<Identifier> getArmorTrimEmptyAdditionSlotTextures() {
        return List.of(EMPTY_SLOT_FEATHER_TEXTURE);
    }

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(WingedBoots.MODID, "winged_boots"), HOVER_BOOTS);
        Registry.register(Registries.ITEM, new Identifier(WingedBoots.MODID, "floaty_smithing_template"), HOVER_TEMPLATE);
        Registry.register(Registries.ITEM, new Identifier(WingedBoots.MODID, "cloud_in_a_bottle"), CLOUD_BOTTLE);
    }

}
