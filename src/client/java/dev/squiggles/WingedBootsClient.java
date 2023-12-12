package dev.squiggles;

import dev.squiggles.entity.CloudEntityRenderer;
import dev.squiggles.entity.CloudModel;
import dev.squiggles.entity.Entities;
import dev.squiggles.entity.ModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;


public class WingedBootsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(Entities.CLOUD_ENTITY, CloudEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModelLayers.CLOUD, CloudModel::getTexturedModelData);
	}
}