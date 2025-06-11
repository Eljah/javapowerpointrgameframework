package com.example.ppgame.example;

import com.example.ppgame.framework.Sprite;
import com.example.ppgame.framework.GameObject;
import com.example.ppgame.framework.interactive.InteractivePowerPointRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Demonstrates creating a slide with a button that triggers a VBA macro.
 */
public class InteractiveExampleGame {
    public static void main(String[] args) throws IOException {
        InteractivePowerPointRenderer renderer = new InteractivePowerPointRenderer();
        Sprite sprite = new Sprite(createDummySprite(), 20, 20);
        GameObject obj = new GameObject(sprite, 50, 50);
        obj.draw(renderer);

        renderer.addMacro("SayHello", "MsgBox \"Hello from VBA!\"");
        renderer.addControlButton("Hello", 40, 150, 80, 30, "SayHello");

        renderer.save("interactive.pptm");
    }

    private static byte[] createDummySprite() throws IOException {
        BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, 20, 20);
        g.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        return baos.toByteArray();
    }
}
