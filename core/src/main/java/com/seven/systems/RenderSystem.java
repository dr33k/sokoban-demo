package com.seven.systems;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.seven.SokobanGame;
import com.seven.assets.Constants;
import com.seven.assets.TileEnum;
import com.seven.entities.Box;
import com.seven.entities.Player;
import com.seven.entities.Tile;
import com.seven.screens.GameScreen;

import java.util.Map;

public class RenderSystem {
    private final SokobanGame game;

    public RenderSystem(SokobanGame game) {
        this.game = game;
    }

    public void update(GameScreen screen, float delta){
        FitViewport viewport = screen.getViewport();
        SpriteBatch spriteBatch = game.getBatch();
        Map<Tile, Box> boxGrid = screen.getBoxGrid();
        Player player = screen.getPlayer();
        TileEnum[][] staticTileGrid = screen.getStaticTileGrid();
        Label currentMovesLabel = screen.getCurrentMovesLabel();
        Stage screenUIStage = screen.getUiStage();

        int noOfRows = staticTileGrid.length;
        int noOfColumns = staticTileGrid[0].length;
        float tileSizeWithPadding = Constants.TILE_SIZE + (2 * Constants.PADDING);
        float gridWidth = noOfColumns * tileSizeWithPadding;
        float gridHeight = noOfRows * tileSizeWithPadding;
        float gridStartX =  (viewport.getWorldWidth() - gridWidth)/2f;
        float gridStartY = (viewport.getWorldHeight() - gridHeight)/2f;

        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);

        ScreenUtils.clear(Color.LIGHT_GRAY);

        spriteBatch.begin();
        for (int y = 0; y < noOfRows; y++){
            for(int x = 0; x < noOfColumns; x++){
                spriteBatch.draw(
                  game.getAssetManager().get(staticTileGrid[y][x].getTextureFilename(), Texture.class),
                  gridStartX + (x * tileSizeWithPadding),
                    gridStartY + (y * tileSizeWithPadding),
                    Constants.TILE_SIZE,
                    Constants.TILE_SIZE
                );
            }
        }

        for(Map.Entry<Tile, Box> entry: boxGrid.entrySet()){
            Texture texture = entry.getValue().getTexture();
            //Check if solved to render solved texture
            if(staticTileGrid[entry.getKey().getY()][entry.getKey().getX()] == TileEnum.TARGET){
                texture = game.getAssetManager().get(Constants.SOLVED, Texture.class);
            }
            spriteBatch.draw(
                texture,
                gridStartX + (entry.getKey().getX() * tileSizeWithPadding),
                gridStartY + (entry.getKey().getY() * tileSizeWithPadding),
                Constants.TILE_SIZE,
                Constants.TILE_SIZE
            );
        }

        spriteBatch.draw(
            player.getTexture(),
            gridStartX + (player.getCurrent().getX() * tileSizeWithPadding),
            gridStartY + (player.getCurrent().getY() * tileSizeWithPadding),
            Constants.TILE_SIZE,
            Constants.TILE_SIZE
        );

        spriteBatch.end();

        currentMovesLabel.setText("Moves: "+ screen.getCurrentLevelMoves());
        screenUIStage.act(delta);
        screenUIStage.draw();
    }
}
