package net.hcml.armadeus.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.hcml.armadeus.ArmadeusMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.awt.*;
import java.util.ArrayList;

public class ModdedHudOverlays {
    private static final ResourceLocation BG = new ResourceLocation(ArmadeusMod.MOD_ID, "textures/gui/hud/bg.png");

    static final int size = 32;
    static final int yoffset = 40;

    public static final IGuiOverlay HUD_INFO = ((gui, poseStack, partialTick, width, height) -> {
        Player player = Minecraft.getInstance().player;
        float xscale = 1f;
        float yscale = 1f;
        if(player.isSpectator()) {

        }else{
            int color = Color.HSBtoRGB(0.0f, 0.0f , 1.0f);
            ArrayList<String> list = new ArrayList<>();
            list.add("Player Kills:");
            list.add("Deaths:");
            list.add("(K/D)R:");
            list.add("Clan:");
            list.add("Money: ");

            width = width/(int)xscale;
            height = height/(int)yscale;
            int xsize = 100;
            int ysize;
            int x = width-xsize;
            int y = 10;

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, BG);
            GuiComponent.blit(poseStack,x-5, 5,0,0,xsize+5,(list.size()*y) + 10, xsize+5,(list.size()*y) + 10);

            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                GuiComponent.drawString(poseStack,Minecraft.getInstance().font,str,x,y*(i+1),color);
            }
        }
    });
}