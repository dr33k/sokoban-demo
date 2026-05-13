package com.seven.config;

import com.badlogic.gdx.graphics.Texture;
import com.seven.assets.TileEnum;
import com.seven.entities.Box;
import com.seven.entities.Player;
import com.seven.entities.Tile;

import java.util.HashMap;
import java.util.Map;

import static com.seven.assets.TileEnum.*;

public class LevelConfig {
    public static TileEnum[][] l1TileGrid(){
        return new TileEnum[][]{
            {WALL, WALL, WALL, WALL, WALL},
            {WALL, FLOOR, FLOOR, TARGET, WALL},
            {WALL, WALL, WALL, WALL, WALL}
        };
    }
    public static Player l1Player(Texture texture){
        return new Player(texture, 1,1);
    }
    public static Map<Tile, Box> l1Boxes(Texture texture){
        Box box = new Box(texture, 1,2);
        Map<Tile, Box> boxGrid = new HashMap<>();
        boxGrid.put(box.getCurrent(), box);
        return boxGrid;
    }

    public static TileEnum[][] l2TileGrid(){
        return new TileEnum[][]{
            {WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FLOOR, FLOOR, FLOOR, FLOOR, WALL},
            {WALL, FLOOR, FLOOR, FLOOR, FLOOR, WALL},
            {WALL, FLOOR, FLOOR, TARGET, FLOOR, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL},
        };
    }

    public static Player l2Player(Texture texture){
        return new Player(texture, 2,2);
    }

    public static Map<Tile, Box> l2Boxes(Texture texture){
        Box box = new Box(texture,2,3);
        Map<Tile, Box> boxGrid = new HashMap<>();
        boxGrid.put(box.getCurrent(), box);
        return boxGrid;
    }

    public static TileEnum[][] l3TileGrid(){
        return new TileEnum[][]{
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FLOOR, FLOOR, TARGET, FLOOR, FLOOR, WALL},
            {WALL, FLOOR, FLOOR, FLOOR, FLOOR, FLOOR, WALL},
            {WALL, FLOOR, TARGET, FLOOR, FLOOR, FLOOR, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL}
        };
    }
    public static Player l3Player(Texture texture){
        return new Player(texture, 3,4);
    }

    public static Map<Tile, Box> l3Boxes(Texture texture){
        Box b1  = new Box(texture, 3, 3);
        Box b2 = new Box(texture,2,3);

        Map<Tile, Box> boxGrid = new HashMap<>();
        boxGrid.put(b1.getCurrent(), b1);
        boxGrid.put(b2.getCurrent(), b2);
        return boxGrid;

    }
}
