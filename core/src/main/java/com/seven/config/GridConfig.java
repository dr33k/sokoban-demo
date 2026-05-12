package com.seven.config;

import com.seven.assets.Constants;
import com.seven.assets.TileEnum;
import com.seven.entities.*;

import java.util.Map;

public class GridConfig {
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
            if(destGridTile == TileEnum.TARGET){ //If box is already solved
                return new MoveState(false, destGridTile, incX, incY);
            }
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
