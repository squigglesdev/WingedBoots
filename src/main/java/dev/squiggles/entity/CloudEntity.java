package dev.squiggles.entity;

import dev.squiggles.WingedBoots;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class CloudEntity extends Entity {
    public CloudEntity(EntityType<? extends Entity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    public void tick() {
        this.setVelocity(new Vec3d(-1,0,0));
        this.baseTick();
    }

    @Override
    public boolean canHit() {
        return true;
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        WingedBoots.LOGGER.info("PLEASE WORK");
        if (player.shouldCancelInteraction()) {
            return ActionResult.PASS;
        }
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.GLASS_BOTTLE)) {
            player.playSound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.0f, 1.0f);
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, dev.squiggles.item.Items.CLOUD_BOTTLE.getDefaultStack());
            player.setStackInHand(hand, itemStack2);
            this.discard();
            return ActionResult.success(this.getWorld().isClient);
        }
        return super.interact(player, hand);
    }

    public static DefaultAttributeContainer.Builder createCloudAttributes() {
        return MobEntity.createMobAttributes();
    }

}
