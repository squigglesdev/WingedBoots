package dev.squiggles.itemgroup;

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
                new Identifier("playerutils", "jolon_group"),
                FabricItemGroup.builder().displayName(Text.translatable("itemgroup.jolon_group"))
                        .icon(() -> new ItemStack(Items.HOVER_BOOTS)).entries((displayContext, entries) -> {
                            entries.add(new ItemStack(Items.HOVER_BOOTS));
                            entries.add(new ItemStack(Items.HOVER_TEMPLATE));
                        }).build());
    }

}
