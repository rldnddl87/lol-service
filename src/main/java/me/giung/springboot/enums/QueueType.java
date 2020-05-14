package me.giung.springboot.enums;

import me.giung.springboot.enums.ifs.EnumModel;

public enum QueueType implements EnumModel {
    RANKED_SOLO_5X5("RANKED_SOLO_5x5");

    private String value;

    QueueType(String value) {
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

    public static QueueType findByString(String str) {
        for (QueueType type : QueueType.values()) {
            if (type.getValue().equals(str))
                return type;
        }
        return null;
    }

}