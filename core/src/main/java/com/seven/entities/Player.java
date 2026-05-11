package com.seven.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.seven.config.GridConfig;

public class Player {
    private Tile current;
    private Tile target;
    private Sprite sprite;

    public Player(Sprite sprite, int currentY, int currentX) {
        this.sprite = sprite;
        this.current = new Tile(currentY, currentX);
        this.target = new Tile(currentY, currentX);
        this.sprite.setPosition(
            GridConfig.toScreenCoordinates(currentX, currentY)
        );
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

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
