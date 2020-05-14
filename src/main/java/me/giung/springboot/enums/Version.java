package me.giung.springboot.enums;

import me.giung.springboot.enums.ifs.EnumModel;

public enum Version implements EnumModel {
    V4("v4"), V3("v3"), V2("v2"), V1("v1");

    private String value;

    Version(String value) {
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