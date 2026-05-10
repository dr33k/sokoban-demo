package com.seven.systems;

import com.seven.assets.TileEnum;
import com.seven.config.GridConfig;
import com.seven.entities.Box;
import com.seven.entities.MoveState;
import com.seven.entities.Player;
import com.seven.entities.Tile;
import com.seven.screens.GameScreen;

import java.util.Map;

public class MotionSystem {
    public void update(GameScreen screen, float delta){
        Player player = screen.getPlayer();
        TileEnum[][] staticTileGrid = screen.getStaticTileGrid();
        Map<Tile, Box> boxGrid = screen.getBoxGrid();

        MoveState moveState = GridConfig.testMove(staticTileGrid, player);
        if(moveState.isCanMove()){
            //Move player
            player.getCurrent().setX(player.getTarget().getX());
            player.getCurrent().setY(player.getTarget().getY());

            if(moveState.getTileEnum() == TileEnum.BOX){
                //Move Box
                Box boxAtTarget = boxGrid.get(player.getTarget());
                boxAtTarget.getCurrent().setX(boxAtTarget.getCurrent().getX() + moveState.getIncX());
                boxAtTarget.getCurrent().setY(boxAtTarget.getCurrent().getY() + moveState.getIncY());
            }
        }
    }
}
