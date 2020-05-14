package me.giung.springboot.enums;

import me.giung.springboot.enums.ifs.EnumModel;

public enum RankingUrl implements EnumModel {

    CHALLENGER_LEAGUE("challengerleagues/by-queue"), GRANDMASTER_LEAGUE("grandmasterleagues/by-queue"),
    MASTER_LEAGUE("masterleagues/by-queue"), ENTRIES("entries");

    private String value;

    RankingUrl(String value) {
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