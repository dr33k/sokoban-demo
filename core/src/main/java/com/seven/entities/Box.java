package com.seven.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Box {
    private Tile current;
    private Sprite sprite;

    public Box(Sprite sprite, int currentY, int currentX) {
        this.sprite = sprite;
        this.current = new Tile(currentY, currentX);
    }
    public Tile getCurrent() {
        return current;
    }

    public void setCurrent(Tile current) {
        this.current = current;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
