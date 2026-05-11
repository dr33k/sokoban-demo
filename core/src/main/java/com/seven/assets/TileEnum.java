package com.seven.assets;

public enum TileEnum {
    WALL(Constants.WALL),
    FLOOR(Constants.FLOOR),
    TARGET(Constants.TARGET),
    BOX(Constants.BOX),
    PLAYER(Constants.PLAYER);

    private final String textureFilename;

    TileEnum(String textureFilename) {
        this.textureFilename = textureFilename;
    }

    public String getTextureFilename() {
        return textureFilename;
    }

}
