package org.multicoder.mcpaintball.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import org.multicoder.mcpaintball.client.ClientPlayerTeamData;

import java.util.function.Supplier;

public class TeamUpdateS2CPacket
{
    private final int Team;
    public TeamUpdateS2CPacket(int T){this.Team = T;}
    public TeamUpdateS2CPacket(FriendlyByteBuf buffer){Team = buffer.readInt();}
    public void toBytes(FriendlyByteBuf buffer){buffer.writeInt(Team);}

    public boolean handlePacket(Supplier<NetworkEvent.Context> supplier)
    {
        NetworkEvent.Context ctx = supplier.get();
        Player player = ctx.getSender();
        Level level = player.level;
        ClientPlayerTeamData.SetTeam(Team);
        player.sendMessage(new TextComponent("Team Updated To: " + Team),null);
        return true;
    }
}
