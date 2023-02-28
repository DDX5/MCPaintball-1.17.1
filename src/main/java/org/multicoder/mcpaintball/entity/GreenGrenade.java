package org.multicoder.mcpaintball.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.multicoder.mcpaintball.init.entityinit;
import org.multicoder.mcpaintball.init.iteminit;

public class GreenGrenade extends ThrowableItemProjectile
{

    public GreenGrenade(double pX, double pY, double pZ, Level pLevel)
    {
        super((EntityType<? extends ThrowableItemProjectile>) entityinit.GREEN_GRENADE.get(), pX, pY, pZ, pLevel);
    }

    public GreenGrenade(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel)
    {
        super(pEntityType, pLevel);
    }

    public GreenGrenade(LivingEntity pShooter, Level pLevel)
    {
        super((EntityType<? extends ThrowableItemProjectile>) entityinit.GREEN_GRENADE.get(), pShooter, pLevel);
    }

    @Override
    protected void onHit(HitResult pResult)
    {
        BlockPos pos = new BlockPos(pResult.getLocation());
        this.level.explode(this,pos.getX(),pos.getY(),pos.getZ(),3, Explosion.BlockInteraction.DESTROY);
        super.onHit(pResult);
    }

    @Override
    protected Item getDefaultItem()
    {
        return iteminit.GREEN_GRENADE.get();
    }
}
