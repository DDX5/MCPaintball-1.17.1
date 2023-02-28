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

public class BlueGrenade extends ThrowableItemProjectile
{

    public BlueGrenade(double pX, double pY, double pZ, Level pLevel)
    {
        super((EntityType<? extends ThrowableItemProjectile>) entityinit.BLUE_GRENADE.get(), pX, pY, pZ, pLevel);
    }

    public BlueGrenade(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel)
    {
        super(pEntityType, pLevel);
    }

    public BlueGrenade(LivingEntity pShooter, Level pLevel)
    {
        super((EntityType<? extends ThrowableItemProjectile>) entityinit.BLUE_GRENADE.get(), pShooter, pLevel);
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
        return iteminit.BLUE_GRENADE.get();
    }
}
