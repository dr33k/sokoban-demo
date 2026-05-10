package com.seven.entities;

import com.seven.assets.TileEnum;

public class MoveState {
    private boolean canMove;
    private TileEnum tileEnum;
    private int incX;
    private int incY;

    public MoveState(boolean canMove, TileEnum tileEnum, int incX, int incY) {
        this.canMove = canMove;
        this.tileEnum = tileEnum;
        this.incX = incX;
        this.incY = incY;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public TileEnum getTileEnum() {
        return tileEnum;
    }

    public void setTileEnum(TileEnum tileEnum) {
        this.tileEnum = tileEnum;
    }

    public int getIncX() {
        return incX;
    }

    public void setIncX(int incX) {
        this.incX = incX;
    }

    public int getIncY() {
        return incY;
    }

    public void setIncY(int incY) {
        this.incY = incY;
    }
}
