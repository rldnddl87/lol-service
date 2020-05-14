package me.giung.springboot.enums;

import me.giung.springboot.enums.ifs.EnumModel;

public enum ApiType implements EnumModel {
    CHAMPION_MASTERY("champion-mastery"), PLATFORM("platform"), LEAGUE("league"), STATUS("status");

    private String value;

    ApiType(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {

        return value;
    }

}