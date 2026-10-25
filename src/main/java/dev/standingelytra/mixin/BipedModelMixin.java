package dev.standingelytra.mixin;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BipedEntityModel.class)
public class BipedModelMixin {

    @Redirect(
        method = "setAngles(Lnet/minecraft/entity/LivingEntity;FFFFF)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/LivingEntity;getFallFlyingTicks()I"
        )
    )
    private int standingelytra$noFlyingPose(LivingEntity entity) {
        if (entity instanceof PlayerEntity) {
            return 0;
        }
        return entity.getFallFlyingTicks();
    }
}
