package org.multicoder.mcpaintball.item.weapons.shotgun;

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

public class RedShotgunItem extends Item
{

    public RedShotgunItem()
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
                if(Team == 1) {
                    AbstractArrow AAE1 = new RedPaintballArrowEntity(level, player);
                    AbstractArrow AAE2 = new RedPaintballArrowEntity(level, player);
                    AbstractArrow AAE3 = new RedPaintballArrowEntity(level, player);
                    AAE1.shootFromRotation(player, player.getXRot(), (player.getYRot() + 16.0f), 0.0f, 3.0f, MCPaintballConfig.SHOTGUN_INACCURACY.get().floatValue());
                    AAE2.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 3.0f, MCPaintballConfig.SHOTGUN_INACCURACY.get().floatValue());
                    AAE3.shootFromRotation(player, player.getXRot(), (player.getYRot() - 16.0f), 0.0f, 3.0f, MCPaintballConfig.SHOTGUN_INACCURACY.get().floatValue());
                    level.addFreshEntity(AAE1);
                    level.addFreshEntity(AAE2);
                    level.addFreshEntity(AAE3);
                    player.getCooldowns().addCooldown(player.getItemInHand(hand).getItem(), 25);
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
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.shotgun_spec").withStyle(ChatFormatting.BOLD));
        }
        else
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.press_shift").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
