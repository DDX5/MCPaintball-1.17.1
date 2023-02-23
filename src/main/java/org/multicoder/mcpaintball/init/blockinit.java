package org.multicoder.mcpaintball.init;


import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.blockitem.ExplosiveBlockItem;
import org.multicoder.mcpaintball.block.explosive.BlueExplosive;
import org.multicoder.mcpaintball.block.explosive.GreenExplosive;
import org.multicoder.mcpaintball.block.explosive.RedExplosive;

import java.util.function.Supplier;

public class blockinit
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MCPaintball.MODID);

    public static final RegistryObject<Block> RED_EXPLOSIVE = registerBlock("utility/red_explosive", RedExplosive::new);
    public static final RegistryObject<Block> BLUE_EXPLOSIVE = registerBlock("utility/blue_explosive", BlueExplosive::new);
    public static final RegistryObject<Block> GREEN_EXPLOSIVE = registerBlock("utility/green_explosive", GreenExplosive::new);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return iteminit.ITEMS.register(name, () -> new ExplosiveBlockItem(block.get()));
    }
}
