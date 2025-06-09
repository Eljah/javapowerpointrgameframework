package com.example.ppgame.framework;

public class GameObject {
    protected double x;
    protected double y;
    protected Sprite sprite;

    public GameObject(Sprite sprite, double x, double y) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }

    public void update(double deltaTime) {
        // Override in subclasses for custom logic
    }

    public void draw(PowerPointRenderer renderer) {
        if (sprite != null) {
            renderer.drawSprite(sprite, x, y);
        }
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
}
