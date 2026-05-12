package com.seven.config;

import com.seven.assets.Constants;
import com.seven.assets.TileEnum;
import com.seven.entities.*;

import java.util.Map;

public class GridConfig {
    public static Coordinate toScreenCoordinates(int gridX, int gridY){
        return new Coordinate(gridX * Constants.TILE_SIZE, gridY * Constants.TILE_SIZE);
    }

    public static MoveState testMove(TileEnum[][] staticTileGrid, Map<Tile, Box> boxGrid, Player player){
        Tile current = player.getCurrent();
        Tile target = player.getTarget();
        int incX = target.getX() - current.getX();
        int incY = target.getY() - current.getY();
        TileEnum destGridTile = staticTileGrid[target.getY()][target.getX()];

        if((destGridTile == TileEnum.FLOOR || destGridTile == TileEnum.TARGET) && !boxGrid.containsKey(target)) {
            return new MoveState(true, destGridTile, incX, incY);
        }
        else if (boxGrid.containsKey(target)) {
            TileEnum behindBox = null;
            if(incY != 0){
                behindBox = staticTileGrid[target.getY() + incY][target.getX()];
            } else if (incX != 0) {
                behindBox = staticTileGrid[target.getY()][target.getX() + incX];
            }
            return new MoveState(behindBox == TileEnum.FLOOR || behindBox == TileEnum.TARGET, TileEnum.BOX, incX, incY);
        }
        return new MoveState(false, destGridTile, incX, incY);
    }
}
