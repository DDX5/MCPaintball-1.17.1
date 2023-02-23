package org.multicoder.mcpaintball.entity.renderer;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.entity.RedPaintballArrowEntity;

@OnlyIn(Dist.CLIENT)
public class RedPaintballArrowRenderer extends ArrowRenderer<RedPaintballArrowEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/red_paintball.png");

    public RedPaintballArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(RedPaintballArrowEntity p_114482_)
    {
        return TEXTURE;
    }
}
