package org.multicoder.mcpaintball.init;



import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import org.multicoder.mcpaintball.MCPaintball;

@Mod.EventBusSubscriber(modid = MCPaintball.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class tabinit
{
    public static final CreativeModeTab main = new CreativeModeTab("mcpaintball.paintball"){

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(iteminit.RED_PISTOL.get());
        }
    };
}
