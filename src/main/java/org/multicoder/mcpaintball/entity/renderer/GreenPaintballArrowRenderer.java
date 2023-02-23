package org.multicoder.mcpaintball.entity.renderer;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.entity.GreenPaintballArrowEntity;

@OnlyIn(Dist.CLIENT)
public class GreenPaintballArrowRenderer extends ArrowRenderer<GreenPaintballArrowEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/green_paintball.png");

    public GreenPaintballArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(GreenPaintballArrowEntity p_114482_)
    {
        return TEXTURE;
    }
}
