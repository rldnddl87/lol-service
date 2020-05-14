package me.giung.springboot.enums;

import me.giung.springboot.enums.ifs.EnumModel;

public enum GameType implements EnumModel {
    LOL("lol"), TFT("tft");

    private String value;

    GameType(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        // TODO Auto-generated method stub
        return name();
    }

    @Override
    public String getValue() {
        // TODO Auto-generated method stub
        return value;
    }

}