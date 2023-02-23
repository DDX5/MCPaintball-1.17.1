package org.multicoder.mcpaintball.entity.renderer;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.entity.BluePaintballArrowEntity;
import org.multicoder.mcpaintball.entity.GreenPaintballHeavyArrowEntity;

@OnlyIn(Dist.CLIENT)
public class GreenPaintballHeavyArrowRenderer extends ArrowRenderer<GreenPaintballHeavyArrowEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/green_paintball_heavy.png");

    public GreenPaintballHeavyArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(GreenPaintballHeavyArrowEntity p_114482_)
    {
        return TEXTURE;
    }
}
