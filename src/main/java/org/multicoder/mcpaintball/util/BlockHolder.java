package org.multicoder.mcpaintball.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.multicoder.mcpaintball.util.config.MCPaintballConfig;

import java.util.ArrayList;
import java.util.List;

public class BlockHolder
{
    public static List<Block> BREAKABLES;

    public static void AppendList()
    {
        BREAKABLES = new ArrayList<>();
        List<String> Blocks = (List<String>) MCPaintballConfig.BREAKABLES.get();
        for(String RL : Blocks){
            BREAKABLES.add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(RL)));
        }
    }
}
