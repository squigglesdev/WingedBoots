package dev.squiggles.entity;

import dev.squiggles.WingedBoots;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CloudEntityRenderer extends EntityRenderer<CloudEntity> {

    private static final Identifier TEXTURE = new Identifier(WingedBoots.MODID, "textures/entity/cloud.png");

    private final CloudModel<CloudEntity> model;
    public CloudEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new CloudModel<>(context.getPart(ModelLayers.CLOUD));
    }

    @Override
    public Identifier getTexture(CloudEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CloudEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        this.model.setAngles(mobEntity, 0, 0, 0, 0, 0);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStack.pop();
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
