package org.multicoder.mcpaintball.item.utility.crafting;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.multicoder.mcpaintball.init.tabinit;

import java.util.List;

public class BlueWeaponBase extends Item
{

    public BlueWeaponBase()
    {
        super(new Properties().tab(tabinit.main));
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.crafting").withStyle(ChatFormatting.RED));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
