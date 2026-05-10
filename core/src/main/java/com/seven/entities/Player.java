package com.seven.entities;

import com.badlogic.gdx.math.Vector2;

public class Player {
    private Tile current;
    private Tile target;

    public Player(int currentY, int currentX) {
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
}
