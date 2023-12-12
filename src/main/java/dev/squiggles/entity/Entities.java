package dev.squiggles.entity;

import dev.squiggles.WingedBoots;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Entities {

    public static final Identifier CLOUD = new Identifier(WingedBoots.MODID, "cloud");
    public static final EntityType<CloudEntity> CLOUD_ENTITY = Registry.register(Registries.ENTITY_TYPE, CLOUD, FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CloudEntity::new).dimensions(EntityDimensions.fixed(3f, 0.8f)).build());


    public static void registerEntities() {
        WingedBoots.LOGGER.info("Registering Entities");
    }
}
