package org.multicoder.mcpaintball;



import net.minecraft.world.entity.EntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.entity.renderer.*;
import org.multicoder.mcpaintball.init.*;
import org.multicoder.mcpaintball.network.Networking;
import org.multicoder.mcpaintball.util.BlockHolder;
import org.multicoder.mcpaintball.util.config.MCPaintballConfig;

@Mod(MCPaintball.MODID)
public class MCPaintball
{
    public static final String MODID = "mcpaintball";
    public static final Logger LOG = LogManager.getLogger(MODID);
    public MCPaintball()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MCPaintballConfig.SPEC,"mcpaintball-common.toml");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);
        bus.addListener(this::EntityRenderersSetup);
        bus.addListener(this::OnCommon);
        iteminit.ITEMS.register(bus);
        blockinit.BLOCKS.register(bus);
        blockentityinit.BLOCK_ENTITIES.register(bus);
        entityinit.ENTITY_TYPES.register(bus);
        soundinit.SOUNDS.register(bus);
    }

    private void EntityRenderersSetup(EntityRenderersEvent.RegisterRenderers event)
    {

        event.registerEntityRenderer((EntityType)entityinit.RED_PAINTBALL.get(), RedPaintballArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.BLUE_PAINTBALL.get(), BluePaintballArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.GREEN_PAINTBALL.get(), GreenPaintballArrowRenderer::new);

        event.registerEntityRenderer((EntityType)entityinit.RED_PAINTBALL_HEAVY.get(), RedPaintballHeavyArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.BLUE_PAINTBALL_HEAVY.get(), BluePaintballHeavyArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.GREEN_PAINTBALL_HEAVY.get(), GreenPaintballHeavyArrowRenderer::new);

    }

    private void OnCommon(FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            BlockHolder.AppendList();
            Networking.Register();
        });
    }
}
