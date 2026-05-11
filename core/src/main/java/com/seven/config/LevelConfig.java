package com.seven.config;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
        return new Player(new Sprite(texture), 1,1);
    }
    public static Map<Tile, Box> l1Boxes(Texture texture){
        Box box = new Box(new Sprite(texture), 2,1);
        Map<Tile, Box> boxGrid = new HashMap<>();
        boxGrid.put(box.getCurrent(), box);
        return boxGrid;
    }

    public static TileEnum[][] l2TileGrid(){
        return new TileEnum[][]{
            {WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FLOOR, FLOOR, WALL, FLOOR, FLOOR},
            {WALL, FLOOR, FLOOR, FLOOR, FLOOR, WALL},
            {WALL, FLOOR, TARGET, WALL, FLOOR, FLOOR},
            {WALL, WALL, WALL, WALL, WALL, WALL},
        };
    }

    public static Player l2Player(Texture texture){
        return new Player(new Sprite(texture), 2,2);
    }

    public static Map<Tile, Box> l2Boxes(Texture texture){
        Box box = new Box(new Sprite(texture),2,3);
        Map<Tile, Box> boxGrid = new HashMap<>();
        boxGrid.put(box.getCurrent(), box);
        return boxGrid;
    }

    public static TileEnum[][] l3TileGrid(){
        return new TileEnum[][]{
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FLOOR, TARGET, FLOOR, WALL, FLOOR, FLOOR},
            {WALL, FLOOR, FLOOR, FLOOR, WALL, FLOOR, FLOOR},
            {WALL, TARGET, FLOOR, FLOOR, FLOOR, WALL, FLOOR},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL}
        };
    }
    public static Player l3Player(Texture texture){
        return new Player(new Sprite(texture), 3,3);
    }

    public static Map<Tile, Box> l3Boxes(Texture texture){
        Box b1  = new Box(new Sprite(texture), 2,2);
        Box b2 = new Box(new Sprite(texture),2,3);

        Map<Tile, Box> boxGrid = new HashMap<>();
        boxGrid.put(b1.getCurrent(), b1);
        boxGrid.put(b2.getCurrent(), b2);
        return boxGrid;

    }
}
