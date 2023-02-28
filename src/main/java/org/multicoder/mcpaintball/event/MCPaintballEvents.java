package org.multicoder.mcpaintball.event;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.capability.PlayerTeamCapability;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;

@Mod.EventBusSubscriber(modid = MCPaintball.MODID)
public class MCPaintballEvents
{
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerTeamCapabilityProvider.CAPABILITY).isPresent()) {
                event.addCapability(new ResourceLocation(MCPaintball.MODID, "team"), new PlayerTeamCapabilityProvider());
            }
        }
    }
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event)
    {
        event.register(PlayerTeamCapability.class);
    }
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath())
        {
            event.getOriginal().reviveCaps();
            event.getOriginal().getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(oldStore -> {
                event.getEntity().getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(newStore -> {
                    newStore.CopyFrom(oldStore);
                    event.getOriginal().invalidateCaps();
                });
            });
        }
    }
}
