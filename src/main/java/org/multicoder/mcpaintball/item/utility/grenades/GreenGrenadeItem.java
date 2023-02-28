package org.multicoder.mcpaintball.item.utility.grenades;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.entity.RedGrenade;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.init.tabinit;

import java.util.List;

public class GreenGrenadeItem extends Item
{

    public GreenGrenadeItem()
    {
        super(new Properties().tab(tabinit.main));
    }


    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        if(Screen.hasShiftDown() && !Screen.hasControlDown())
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.grenade").withStyle(ChatFormatting.BOLD));
        }
        else if(Screen.hasControlDown() && Screen.hasShiftDown())
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.grenade_funny").withStyle(ChatFormatting.BOLD));
        }
        else
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.press_shift").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        if(!pLevel.isClientSide())
        {
            pPlayer.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                if(cap.GetTeam() == 2)
                {
                    ItemStack stack = pPlayer.getItemInHand(pUsedHand);
                    pLevel.playSound(null,pPlayer.blockPosition(), soundinit.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                    RedGrenade RG = new RedGrenade(pPlayer,pLevel);
                    RG.setItem(pPlayer.getItemInHand(pUsedHand));
                    RG.shootFromRotation(pPlayer,pPlayer.getXRot(),pPlayer.getYRot(), 0.0f, 3.0f,2.5f);
                    pLevel.addFreshEntity(RG);
                    pPlayer.getCooldowns().addCooldown(this,30);
                    stack.shrink(1);
                }
            });

        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
