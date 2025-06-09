package com.example.ppgame.framework;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Sprite {
    private final byte[] data;
    private final int width;
    private final int height;

    public Sprite(byte[] data, int width, int height) {
        this.data = data;
        this.width = width;
        this.height = height;
    }

    public InputStream getResourceStream() {
        return new ByteArrayInputStream(data);
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
