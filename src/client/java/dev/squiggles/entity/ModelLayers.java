package dev.squiggles.entity;

import dev.squiggles.WingedBoots;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModelLayers {
    public static final EntityModelLayer CLOUD = new EntityModelLayer(new Identifier(WingedBoots.MODID, "cloud"), "main");
}
