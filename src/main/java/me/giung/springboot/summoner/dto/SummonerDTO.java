package me.giung.springboot.summoner.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.giung.springboot.summoner.entity.Summoner;

@NoArgsConstructor
@Setter
@Getter
public class SummonerDTO {

    String accountId;

    int profileIconId;

    long revisionDate;

    String name;

    String id;

    String puuId;

    long summonerLevel;

    public Summoner toEntity() {
        return Summoner.builder().accountId(accountId).profileIconId(profileIconId).revisionDate(revisionDate)
                .name(name).id(id).puuId(puuId).summonerLevel(summonerLevel).build();
    }
}