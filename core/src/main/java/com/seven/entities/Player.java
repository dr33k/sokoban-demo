package com.seven.entities;

import com.badlogic.gdx.graphics.Texture;

public class Player {
    private Tile current;
    private Tile target;
    private Texture texture;

    public Player(Texture texture, int currentY, int currentX) {
        this.texture = texture;
        this.current = new Tile(currentY, currentX);
        this.target = new Tile(currentY, currentX);
    }

    public Tile getCurrent() {
        return current;
    }

    public void setCurrent(Tile current) {
        this.current = current;
    }

    public Tile getTarget() {
        return target;
    }

    public void setTarget(Tile target) {
        this.target = target;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
