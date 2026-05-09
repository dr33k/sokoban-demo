package com.seven.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.seven.SokobanGame;
import com.seven.assets.Constants;
import jdk.vm.ci.meta.Constant;

public class GameScreen implements Screen {
    private final SokobanGame game;
    private final FitViewport viewport;

    public GameScreen(SokobanGame game) {
        this.game = game;
        this.viewport = new FitViewport(Constants.W1, Constants.H1);
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
