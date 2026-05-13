package com.seven.persistence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class PersistenceManager {
    public static final String HIGHEST_UNLOCKED_KEY = "HighestUnlocked";
    public static final String PROTOTYPE = "SokobanPrototype";
    private static PersistenceManager instance;
    private final Preferences prefs;
    private int highestUnlocked;

    private PersistenceManager(){
        prefs = Gdx.app.getPreferences(PROTOTYPE);
        highestUnlocked = prefs.getInteger(HIGHEST_UNLOCKED_KEY);
    }

    public static PersistenceManager getInstance(){
        if(instance == null){
            instance = new PersistenceManager();
        }
        return instance;
    }

    public int getHighestUnlocked(){return highestUnlocked;}
    public int getBestMoves(int level){
        return prefs.getInteger("Level"+level+"BestMoves",Integer.MAX_VALUE);
    }
    public void registerLevelWin(int currentLevel, int currentLevelMoves){
        String currentLevelBestMovesKey = "Level" + currentLevel + "BestMoves";

        //Update best moves
        int currentLevelBestMoves = prefs.getInteger(currentLevelBestMovesKey, Integer.MAX_VALUE);
        if(currentLevelMoves < currentLevelBestMoves){
            currentLevelBestMoves = currentLevelMoves;
            prefs.putInteger(currentLevelBestMovesKey, currentLevelBestMoves);
        }

        //Update highest unlocked
        if(currentLevel > highestUnlocked){
            highestUnlocked = currentLevel;
            prefs.putInteger(HIGHEST_UNLOCKED_KEY, highestUnlocked);
        }
    }

    public void flush(){
        prefs.flush();
    }
}
