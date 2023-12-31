package dev.squiggles.itemgroup;

import dev.squiggles.WingedBoots;
import dev.squiggles.item.Items;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {

    public static ItemGroup JOLON_GROUP;


    public static void registerItemGroups() {
        JOLON_GROUP = Registry.register(Registries.ITEM_GROUP,
                new Identifier(WingedBoots.MODID, "winged_boots"),
                FabricItemGroup.builder().displayName(Text.translatable("itemgroup.jolon_group"))
                        .icon(() -> new ItemStack(net.minecraft.item.Items.FEATHER)).entries((displayContext, entries) -> {
                            entries.add(new ItemStack(Items.WINGED_BOOTS));
                            entries.add(new ItemStack(Items.HOVER_TEMPLATE));
                            entries.add(new ItemStack(Items.CLOUD_BOTTLE));
                        }).build());
    }

}
