package com.seven.config;

import com.badlogic.gdx.utils.Array;
import com.seven.assets.TileEnum;
import com.seven.entities.Box;
import com.seven.entities.Player;

import static com.seven.assets.TileEnum.*;

public class LevelConfig {
    public static TileEnum[][] l1TileGrid(){
        return new TileEnum[][]{
            {WALL, WALL, WALL, WALL, WALL},
            {WALL, FLOOR, FLOOR, TARGET, WALL},
            {WALL, WALL, WALL, WALL, WALL}
        };
    }
    public static Player l1Player(){
        return new Player(1,1);
    }
    public static Array<Box> l1Boxes(){
        return Array.with(new Box(2,1));
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

    public static Player l2Player(){
        return new Player(2,2);
    }

    public static Array<Box> l2Boxes(){
        return Array.with(new Box(2,3));
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
    public static Player l3Player(){
        return new Player(3,3);
    }

    public static Array<Box> l3Boxes(){
        return Array.with(
            new Box(2,2),
            new Box(2,3)
        );
    }
}
