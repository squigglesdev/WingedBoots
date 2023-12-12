package dev.squiggles;

import dev.squiggles.effect.StatusEffects;
import dev.squiggles.entity.Entities;
import dev.squiggles.item.Items;
import dev.squiggles.itemgroup.ItemGroups;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WingedBoots implements ModInitializer {

	public static final String MODID = "wingedboots";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {

		Items.registerItems();
		StatusEffects.registerEffects();
		ItemGroups.registerItemGroups();
		Entities.registerEntities();

	}
}