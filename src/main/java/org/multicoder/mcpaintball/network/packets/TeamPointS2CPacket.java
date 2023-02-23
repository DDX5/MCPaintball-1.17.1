package org.multicoder.mcpaintball.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import org.multicoder.mcpaintball.client.ClientPlayerTeamData;

import java.util.function.Supplier;

public class TeamPointS2CPacket
{
    private final int Points;
    public TeamPointS2CPacket(int Point){Points = Point;}
    public TeamPointS2CPacket(FriendlyByteBuf buffer){Points = buffer.readInt();}
    public void toBytes(FriendlyByteBuf buffer){buffer.writeInt(Points);}

    public boolean handlePacket(Supplier<NetworkEvent.Context> supplier)
    {
        NetworkEvent.Context ctx = supplier.get();
        ClientPlayerTeamData.SetPoints(Points);
        return true;
    }
}
