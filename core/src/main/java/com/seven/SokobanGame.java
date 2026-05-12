package com.seven;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.seven.assets.Constants;
import com.seven.screens.GameScreen;
import com.seven.screens.MenuScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class SokobanGame extends Game {
    private SpriteBatch batch;
    private AssetManager assetManager;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        assetManager = new AssetManager();
        font = new BitmapFont();

        assetManager.load(Constants.BOX, Texture.class);
        assetManager.load(Constants.PLAYER, Texture.class);
        assetManager.load(Constants.TARGET, Texture.class);
        assetManager.load(Constants.FLOOR, Texture.class);
        assetManager.load(Constants.WALL, Texture.class);
        assetManager.load(Constants.SOLVED, Texture.class);

        assetManager.finishLoading();
        this.setScreen(new MenuScreen(this));
    }


    @Override
    public void dispose() {
        batch.dispose();
        assetManager.dispose();
        font.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public BitmapFont getFont() {
        return font;
    }
}
