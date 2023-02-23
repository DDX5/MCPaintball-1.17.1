package org.multicoder.mcpaintball.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerTeamCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag>
{
    public static Capability<PlayerTeamCapability> CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerTeamCapability>() {});
    public PlayerTeamCapability TEAM = null;
    public LazyOptional<PlayerTeamCapability> optional = LazyOptional.of(this::CreateCapabiliy);

    private PlayerTeamCapability CreateCapabiliy()
    {
        if(this.TEAM == null)
        {
            this.TEAM = new PlayerTeamCapability();
        }
        return this.TEAM;
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side)
    {
        if(cap == CAPABILITY)
        {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag nbt = new CompoundTag();
        this.CreateCapabiliy().saveNBT(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt)
    {
        this.CreateCapabiliy().readNBT(nbt);
    }
}
