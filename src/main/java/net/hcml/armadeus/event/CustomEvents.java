package net.hcml.armadeus.event;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.Event;

public class CustomEvents {

    public enum VitalsType {
        THIRST,
        BLOOD,
        LEGS
    }

    public static class onPlayerVitalsChange extends Event {
        private final Player player;
        private final int amount;
        private final VitalsType type;

        public onPlayerVitalsChange(Player player, int amount, VitalsType type) {
            this.player = player;
            this.type = type;
            this.amount = amount;
        }

        public Player getPlayer() {
            return player;
        }

        public int getAmount(){
            return amount;
        }

        public boolean isThirst(){
            return (this.type == VitalsType.THIRST);
        }

        public boolean isBlood(){
            return (this.type == VitalsType.BLOOD);
        }

        public VitalsType getType() {
            return type;
        }
    }
}