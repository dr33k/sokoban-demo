package com.seven.entities;

import com.badlogic.gdx.graphics.Texture;

public class Box {
    private Tile current;
    private Texture texture;

    public Box(Texture texture, int currentY, int currentX) {
        this.texture = texture;
        this.current = new Tile(currentY, currentX);
    }
    public Tile getCurrent() {
        return current;
    }

    public void setCurrent(Tile current) {
        this.current = current;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
