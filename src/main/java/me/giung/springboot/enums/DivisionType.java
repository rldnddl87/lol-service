package me.giung.springboot.enums;

import me.giung.springboot.enums.ifs.EnumModel;

public enum DivisionType implements EnumModel {
    I("I"), II("II"), III("III"), IV("IV");

    private String value;

    DivisionType(String value) {
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

    public static DivisionType findByString(String str) {
        for (DivisionType type : DivisionType.values()) {
            if (type.getValue().equals(str))
                return type;
        }
        return null;
    }
}