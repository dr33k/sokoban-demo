package com.seven.systems;

import com.seven.assets.TileEnum;
import com.seven.entities.Box;
import com.seven.entities.Tile;
import com.seven.persistence.PersistenceManager;
import com.seven.screens.GameScreen;

import java.util.Map;

public class LevelSystem {
    public void checkWin(GameScreen screen){
        Map<Tile, Box> boxGrid = screen.getBoxGrid();
        TileEnum[][] staticTileGrid = screen.getStaticTileGrid();
        boolean isComplete = true;

        for(Tile boxTile: boxGrid.keySet()){
            if (staticTileGrid[boxTile.getY()][boxTile.getX()] != TileEnum.TARGET) {
                isComplete = false;
                break;
            }
        }
        if(isComplete){
            //Persist
            PersistenceManager.getInstance().registerLevelWin(screen.getCurrentLevel(), screen.getCurrentLevelMoves());
            PersistenceManager.getInstance().flush();
        }
        screen.setCurrentLevelComplete(isComplete);
    }
}
