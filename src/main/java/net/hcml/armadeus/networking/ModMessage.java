package net.hcml.armadeus.networking;

import net.hcml.armadeus.ArmadeusMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessage {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(ArmadeusMod.MOD_ID, "message"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        /*net.messageBuilder(VitalsDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(VitalsDataSyncS2CPacket::new)
                .encoder(VitalsDataSyncS2CPacket::toBytes)
                .consumerMainThread(VitalsDataSyncS2CPacket::handle)
                .add();

        net.messageBuilder(PronningC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PronningC2SPacket::new)
                .encoder(PronningC2SPacket::toBytes)
                .consumerMainThread(PronningC2SPacket::handle)
                .add();*/
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToServer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
