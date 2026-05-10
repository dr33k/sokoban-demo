package com.seven.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.seven.SokobanGame;
import com.seven.assets.Constants;
import com.seven.assets.TileEnum;
import com.seven.config.LevelConfig;
import com.seven.entities.Box;
import com.seven.entities.Player;
import com.seven.entities.Tile;

import java.util.HashMap;
import java.util.Map;

public class GameScreen implements Screen, InputProcessor {
    private final SokobanGame game;
    private final FitViewport viewport;
    private final Array<Sprite> prototypes;
    private final TileEnum[][] staticTileGrid;
    private final Player player;
    private final Map<Tile, Box> boxGrid;


    public GameScreen(SokobanGame game) {
        this.game = game;
        viewport = new FitViewport(Constants.W1, Constants.H1);
        staticTileGrid = LevelConfig.l1TileGrid();
        player = LevelConfig.l1Player();
        Array<Box> boxes = LevelConfig.l1Boxes();

        boxGrid = new HashMap<>();
        for (Box box :
            boxes) {
            boxGrid.put(box.getCurrent(), box);
        }

        prototypes = Array.with(
            new Sprite(game.getAssetManager().get(Constants.PLAYER, Texture.class)),
            new Sprite(game.getAssetManager().get(Constants.WALL, Texture.class)),
            new Sprite(game.getAssetManager().get(Constants.FLOOR, Texture.class)),
            new Sprite(game.getAssetManager().get(Constants.BOX, Texture.class)),
            new Sprite(game.getAssetManager().get(Constants.TARGET, Texture.class)),
            new Sprite(game.getAssetManager().get(Constants.SOLVED, Texture.class))
        );
    }

    public FitViewport getViewport() {
        return viewport;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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

    @Override
    public boolean keyDown(int keycode) {
        Tile playerCurrentTile = player.getCurrent();
        Tile playerTargetTile = player.getTarget();

        if(keycode == Input.Keys.UP || keycode == Input.Keys.W){
            playerTargetTile.setY(playerCurrentTile.getY()+1);
            return true;
        }else if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
            playerTargetTile.setY(playerCurrentTile.getY()-1);
            return true;
        }else if(keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
            playerTargetTile.setX(playerCurrentTile.getX()-1);
            return true;
        }else if(keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
            playerTargetTile.setX(playerCurrentTile.getX()+1);
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
}
