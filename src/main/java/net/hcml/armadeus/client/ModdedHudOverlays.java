package net.hcml.armadeus.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.hcml.armadeus.ArmadeusMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.minecraftforge.client.model.obj.ObjLoader;
import org.lwjgl.opengl.GL11;

import org.w3c.dom.Node;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.List;

import static com.mojang.blaze3d.systems.RenderSystem.glBindVertexArray;
import static org.lwjgl.opengl.GL11.*;

public class ModdedHudOverlays {
    private static final ResourceLocation BG = new ResourceLocation(ArmadeusMod.MOD_ID, "textures/gui/hud/bg.png");

    static final int size = 32;
    static final int yoffset = 40;
    ObjLoader
    private Node rootNode;
    private List<Geometry> geometries;

    public ObjModel(String objFile, AssetManager assetManager) {
        // Set up the asset manager to search for the OBJ file in the local file system
        assetManager.registerLocator("", FileLocator.class);

        // Load the OBJ file using the Wavefront OBJ Loader
        rootNode = (Node) assetManager.loadModel(objFile);

        // Extract the geometries from the root node
        geometries = rootNode.getChildren();
    }

    public static final IGuiOverlay VIEW_MODEL = ((gui, poseStack, partialTick, width, height) -> {
        Player player = Minecraft.getInstance().player;
        Matrix4f modelMatrix = new Matrix4f();
        modelMatrix.setIdentity();
        modelMatrix.translate(new Vector3f(0.5f, -0.5f, 0.5f));

        // Bind the gun model's VAO and draw the current frame of the animation
        glBindVertexArray(gunModel.getVaoID());
        glDrawElements(GL_TRIANGLES, gunModel.getVertexCount(), GL_UNSIGNED_INT, 0);
    });
    //modelMatrix((float) Math.toRadians(-45), new Vector3f(0, 1, 0));

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