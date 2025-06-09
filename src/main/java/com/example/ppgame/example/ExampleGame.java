package com.example.ppgame.example;

import com.example.ppgame.framework.Game;
import com.example.ppgame.framework.GameObject;
import com.example.ppgame.framework.PowerPointRenderer;
import com.example.ppgame.framework.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import java.io.IOException;

public class ExampleGame extends Game {
    private GameObject player;

    public ExampleGame(PowerPointRenderer renderer) {
        super(renderer);
        try {
            Sprite sprite = new Sprite(createDummySprite(), 20, 20);
            player = new GameObject(sprite, 50, 50);
            addObject(player);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] createDummySprite() throws IOException {
        BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 20, 20);
        g.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        return baos.toByteArray();
    }

    @Override
    protected void onUpdate(double delta) {
        // Simple animation: move to the right
        player.setX(player.getX() + 10 * delta);
    }

    public static void main(String[] args) throws IOException {
        PowerPointRenderer renderer = new PowerPointRenderer();
        ExampleGame game = new ExampleGame(renderer);
        game.run(10); // 10 frames
        renderer.save("game.pptx");
    }
}
