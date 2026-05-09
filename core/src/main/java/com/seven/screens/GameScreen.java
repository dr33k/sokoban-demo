package com.seven.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture3D;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.seven.SokobanGame;
import com.seven.assets.Constants;
import com.seven.assets.TileEnum;
import com.seven.entities.Tile;

import java.util.HashMap;
import java.util.Map;

public class GameScreen implements Screen {
    private final SokobanGame game;
    private final FitViewport viewport;
    private final Array<Sprite> prototypes;
    private final TileEnum[][] staticTileGrid;
    private final Map<Vector2, Tile> movableTilesGrid;

    public GameScreen(SokobanGame game) {
        this.game = game;
        viewport = new FitViewport(Constants.W1, Constants.H1);
        staticTileGrid = new TileEnum[5][6];
        movableTilesGrid = new HashMap<>();

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
}
