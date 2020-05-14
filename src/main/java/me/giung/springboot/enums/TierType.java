package me.giung.springboot.enums;

import me.giung.springboot.enums.ifs.EnumModel;

public enum TierType implements EnumModel {

    CHALLENGER("CHALLENGER"), GRANDMASTER("GRANDMASTER"), MASTER("MASTER"), DIAMOND("DIAMOND"), PLATINUM("PLATINUM"),
    GOLD("GOLD"), SILVER("SILVER"), BRONZE("BRONZE"), IRON("IRON");

    private String value;

    TierType(final String value) {
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

    public static TierType findByString(String str) {

        for (TierType type : TierType.values()) {
            if (type.getValue().equals(str)) {
                return type;
            }
        }
        return null;
    }

}