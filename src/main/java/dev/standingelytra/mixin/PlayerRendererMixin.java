package dev.standingelytra.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntityRenderer.class)
public class PlayerRendererMixin {

    @Redirect(
        method = "setupTransforms(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/client/util/math/MatrixStack;FFFF)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;isFallFlying()Z"
        )
    )
    private boolean standingelytra$noFlyingTilt(AbstractClientPlayerEntity player) {
        return false;
    }
}
