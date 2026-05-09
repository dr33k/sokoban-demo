package com.seven.config;

import com.seven.assets.Constants;
import com.seven.entities.Coordinate;

public class GridConfig {
    public static Coordinate toScreenCoordinates(int x, int y){
        return new Coordinate(x * Constants.TILE_SIZE, y * Constants.TILE_SIZE);
    }
}
