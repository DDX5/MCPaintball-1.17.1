package org.multicoder.mcpaintball.item.weapons.rifle;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.entity.RedPaintballArrowEntity;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.init.tabinit;
import org.multicoder.mcpaintball.util.config.MCPaintballConfig;

import java.util.List;

public class RedRifleItem extends Item
{

    public RedRifleItem()
    {
        super(new Properties().tab(tabinit.main));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        if(!level.isClientSide)
        {
            player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->
            {
                int Team = cap.GetTeam();
                if (Team == 1) {
                    AbstractArrow AAE = new RedPaintballArrowEntity(level, player);
                    AAE.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 5.0f, MCPaintballConfig.PISTOL_INACCURACY.get().floatValue());
                    level.addFreshEntity(AAE);
                    player.getCooldowns().addCooldown(player.getItemInHand(hand).getItem(), 10);
                    level.playSound(null,player.blockPosition(), soundinit.SINGLE_SHOT.get(), SoundSource.PLAYERS,1f,1f);
                }
            });
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        if(Screen.hasShiftDown())
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.rifle_spec").withStyle(ChatFormatting.BOLD));
        }
        else
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.press_shift").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
