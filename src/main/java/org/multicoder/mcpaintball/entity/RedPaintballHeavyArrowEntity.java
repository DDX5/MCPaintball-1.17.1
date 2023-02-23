package org.multicoder.mcpaintball.entity;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.init.entityinit;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.network.Networking;
import org.multicoder.mcpaintball.network.packets.TeamPointS2CPacket;

public class RedPaintballHeavyArrowEntity extends AbstractArrow
{

    public RedPaintballHeavyArrowEntity(EntityType<? extends Entity> p_36858_, Level p_36859_) {super((EntityType<? extends AbstractArrow>) p_36858_, p_36859_);}

    public RedPaintballHeavyArrowEntity(Level p_36861_, double p_36862_, double p_36863_, double p_36864_) {super((EntityType<? extends AbstractArrow>) entityinit.RED_PAINTBALL_HEAVY.get(), p_36862_, p_36863_, p_36864_,p_36861_);}

    public RedPaintballHeavyArrowEntity(Level p_36866_, LivingEntity p_36867_) {super((EntityType<? extends AbstractArrow>) entityinit.RED_PAINTBALL_HEAVY.get(), p_36867_,p_36866_);}

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {return null;}

    

    @Override
    protected ItemStack getPickupItem() {return ItemStack.EMPTY;}


    @Override
    protected void onHitEntity(EntityHitResult p_36757_)
    {
        if(!level.isClientSide)
        {
            if (p_36757_.getEntity() instanceof ServerPlayer)
            {
                ServerPlayer player = (ServerPlayer) getOwner();
                player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                    cap.IncPoints();
                    Networking.sendToPlayer(new TeamPointS2CPacket(cap.GetPoints()),player);
                });
            }
            this.discard();
        }
    }

    @Override
    protected void onHit(HitResult pResult)
    {
        this.level.explode(null,this.getX(),this.getY(),this.getZ(),2f, Explosion.BlockInteraction.DESTROY);
        this.kill();
    }
}
