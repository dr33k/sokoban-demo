package com.seven.entities;

public class Box {
    private Tile current;

    public Box(int currentY, int currentX) {
        this.current = new Tile(currentY, currentX);
    }
    public Tile getCurrent() {
        return current;
    }

    public void setCurrent(Tile current) {
        this.current = current;
    }
}
