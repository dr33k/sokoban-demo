package com.seven.systems;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.seven.SokobanGame;
import com.seven.screens.GameScreen;

public class RenderSystem {
    private final SokobanGame game;

    public RenderSystem(SokobanGame game) {
        this.game = game;
    }

    public void update(GameScreen screen){
        FitViewport viewport = screen.getViewport();
        SpriteBatch spriteBatch = game.getBatch();

        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);

        ScreenUtils.clear(Color.LIGHT_GRAY);

        spriteBatch.begin();

        spriteBatch.end();
    }
}
