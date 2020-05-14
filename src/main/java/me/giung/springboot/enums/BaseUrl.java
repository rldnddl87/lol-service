package me.giung.springboot.enums;

import me.giung.springboot.enums.ifs.EnumModel;

public enum BaseUrl implements EnumModel {
    BASE_KOR("https://kr.api.riotgames.com");

    private String value;

    BaseUrl(String value) {
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