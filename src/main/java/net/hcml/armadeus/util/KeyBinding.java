package net.hcml.armadeus.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY = "key.category.armadeus.general";
    public static final String KEY_PRONE = "key.armadeus.prone";

    public static final KeyMapping PRONE_KEY = new KeyMapping(KEY_PRONE, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY);
}
