package me.giung.springboot.enums;

import me.giung.springboot.enums.ifs.EnumModel;

public enum SummonerUrl implements EnumModel {
    /// lol/summoner/v4/summoners/by-name/{summonerName}
    BY_NAME("by-name"), SUMMONER("summoner"), SUMMONERS("summoners"), BY_SUMMONER("by-summoner");

    private String value;

    SummonerUrl(String value) {
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