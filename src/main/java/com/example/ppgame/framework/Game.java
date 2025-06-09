package com.example.ppgame.framework;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    private final List<GameObject> objects = new ArrayList<>();
    protected final PowerPointRenderer renderer;

    public Game(PowerPointRenderer renderer) {
        this.renderer = renderer;
    }

    public void addObject(GameObject obj) {
        objects.add(obj);
    }

    public void run(int frames) {
        for (int i = 0; i < frames; i++) {
            update(1.0 / 60.0); // fixed timestep
            draw();
            renderer.newFrame();
        }
    }

    private void update(double delta) {
        onUpdate(delta);
        for (GameObject obj : objects) {
            obj.update(delta);
        }
    }

    private void draw() {
        for (GameObject obj : objects) {
            obj.draw(renderer);
        }
    }

    protected abstract void onUpdate(double delta);
}
