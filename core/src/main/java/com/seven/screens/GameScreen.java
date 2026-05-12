package com.seven.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.seven.SokobanGame;
import com.seven.assets.Constants;
import com.seven.assets.TileEnum;
import com.seven.config.LevelConfig;
import com.seven.entities.Box;
import com.seven.entities.Player;
import com.seven.entities.Tile;
import com.seven.systems.LevelSystem;
import com.seven.systems.MotionSystem;
import com.seven.systems.RenderSystem;

import java.util.Map;

public class GameScreen implements Screen, InputProcessor {
    private final SokobanGame game;
    private final FitViewport viewport;
    private final Array<Sprite> prototypes;
    private  TileEnum[][] staticTileGrid;
    private  Player player;
    private  Map<Tile, Box> boxGrid;
    private int currentLevelMoves;
    private int currentLevelIndex;
    private boolean isCurrentLevelComplete;

    private final MotionSystem motionSystem;
    private final RenderSystem renderSystem;
    private final LevelSystem levelSystem;


    public GameScreen(SokobanGame game) {
        this.game = game;
        viewport = new FitViewport(Constants.W1, Constants.H1);
        staticTileGrid = LevelConfig.l1TileGrid();
        player = LevelConfig.l1Player(game.getAssetManager().get(Constants.PLAYER, Texture.class));
        boxGrid = LevelConfig.l1Boxes(game.getAssetManager().get(Constants.BOX, Texture.class));

        prototypes = Array.with(
            new Sprite(game.getAssetManager().get(Constants.PLAYER, Texture.class)),
            new Sprite(game.getAssetManager().get(Constants.WALL, Texture.class)),
            new Sprite(game.getAssetManager().get(Constants.FLOOR, Texture.class)),
            new Sprite(game.getAssetManager().get(Constants.BOX, Texture.class)),
            new Sprite(game.getAssetManager().get(Constants.TARGET, Texture.class)),
            new Sprite(game.getAssetManager().get(Constants.SOLVED, Texture.class))
        );

        currentLevelMoves = 0;
        currentLevelIndex = 0;
        isCurrentLevelComplete = false;

        motionSystem = new MotionSystem();
        renderSystem = new RenderSystem(game);
        levelSystem = new LevelSystem();
    }

    public FitViewport getViewport() {
        return viewport;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        motionSystem.update(this, delta);
        levelSystem.checkWin(this);
        renderSystem.update(this);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    public void loadLevel(int currentLevelIndex){
        currentLevelMoves = 0;
        isCurrentLevelComplete = false;
        switch(currentLevelIndex){
            case 1: {
                player = LevelConfig.l1Player(game.getAssetManager().get(Constants.PLAYER, Texture.class));
                boxGrid = LevelConfig.l1Boxes(game.getAssetManager().get(Constants.BOX, Texture.class));
                staticTileGrid = LevelConfig.l1TileGrid();
                break;
            }
            case 2: {
                player = LevelConfig.l2Player(game.getAssetManager().get(Constants.PLAYER, Texture.class));
                boxGrid = LevelConfig.l2Boxes(game.getAssetManager().get(Constants.BOX, Texture.class));
                staticTileGrid = LevelConfig.l2TileGrid();
                break;
            }
            case 3: {
                player = LevelConfig.l3Player(game.getAssetManager().get(Constants.PLAYER, Texture.class));
                boxGrid = LevelConfig.l3Boxes(game.getAssetManager().get(Constants.BOX, Texture.class));
                staticTileGrid = LevelConfig.l3TileGrid();
                break;
            }
        }

    }

    @Override
    public boolean keyDown(int keycode) {
        Tile playerCurrentTile = player.getCurrent();
        Tile playerTargetTile = player.getTarget();

        if(keycode == Input.Keys.UP || keycode == Input.Keys.W){
            playerTargetTile.setY(
                MathUtils.clamp(playerCurrentTile.getY()+1, 0, staticTileGrid.length-1)
            );
            return true;
        }else if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
            playerTargetTile.setY(
                MathUtils.clamp(playerCurrentTile.getY()-1, 0, staticTileGrid.length-1)
            );
            return true;
        }else if(keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
            playerTargetTile.setX(
                MathUtils.clamp(playerCurrentTile.getX()-1, 0, staticTileGrid[0].length-1)
            );
            return true;
        }else if(keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
            playerTargetTile.setX(
                MathUtils.clamp(playerCurrentTile.getX()+1, 0, staticTileGrid[0].length-1)
            );
            return true;
        }else if(keycode == Input.Keys.R){
            loadLevel(currentLevelIndex);
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public Array<Sprite> getPrototypes() {
        return prototypes;
    }

    public TileEnum[][] getStaticTileGrid() {
        return staticTileGrid;
    }

    public Player getPlayer() {
        return player;
    }

    public Map<Tile, Box> getBoxGrid() {
        return boxGrid;
    }

    public int getCurrentLevelMoves() {
        return currentLevelMoves;
    }

    public void setCurrentLevelMoves(int currentLevelMoves) {
        this.currentLevelMoves = currentLevelMoves;
    }

    public boolean isCurrentLevelComplete() {
        return isCurrentLevelComplete;
    }

    public void setCurrentLevelComplete(boolean currentLevelComplete) {
        isCurrentLevelComplete = currentLevelComplete;
    }
}
