package org.multicoder.mcpaintball.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fmllegacy.network.NetworkDirection;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.PacketDistributor;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.network.packets.TeamPointS2CPacket;
import org.multicoder.mcpaintball.network.packets.TeamUpdateS2CPacket;

public class Networking
{
    private static SimpleChannel INSTANCE;
    private static int id = 0;
    private static int ID(){
        return id++;
    }

    public static void Register()
    {
        //Create Channel
        SimpleChannel net = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(MCPaintball.MODID,"messsage")).networkProtocolVersion(() -> "1.0.0").clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true).simpleChannel();

        //Assign Instance to created channel
        INSTANCE = net;

        //Register Packets
        net.messageBuilder(TeamUpdateS2CPacket.class,ID(), NetworkDirection.PLAY_TO_CLIENT).decoder(TeamUpdateS2CPacket::new).encoder(TeamUpdateS2CPacket::toBytes).consumer(TeamUpdateS2CPacket::handlePacket).add();
        net.messageBuilder(TeamPointS2CPacket.class,ID(),NetworkDirection.PLAY_TO_CLIENT).decoder(TeamPointS2CPacket::new).encoder(TeamPointS2CPacket::toBytes).consumer(TeamPointS2CPacket::handlePacket).add();

    }

    public static <MSG> void SendToServer(MSG message)
    {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player)
    {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public static <MSG> void sendToClients(MSG message) {INSTANCE.send(PacketDistributor.ALL.noArg(), message);}
}
