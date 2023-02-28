package org.multicoder.mcpaintball.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.multicoder.mcpaintball.MCPaintball;

public class soundinit
{
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MCPaintball.MODID);

    public static final RegistryObject<SoundEvent> SINGLE_SHOT = RegSound("single");
    public static final RegistryObject<SoundEvent> BAZOOKA = RegSound("bazooka");

    public static final RegistryObject<SoundEvent> DING = RegSound("ding");
    public static final RegistryObject<SoundEvent> SPLAT = RegSound("splat");

    public static final RegistryObject<SoundEvent> SET = RegSound("set");

    public static final RegistryObject<SoundEvent> REM = RegSound("rem");

    public static final RegistryObject<SoundEvent> DET = RegSound("det");
    public static final RegistryObject<SoundEvent> GRENADE = RegSound("grenade");

    public static RegistryObject<SoundEvent> RegSound(String name)
    {
        return SOUNDS.register(name,() -> new SoundEvent(new ResourceLocation(MCPaintball.MODID,name)));
    }
}
