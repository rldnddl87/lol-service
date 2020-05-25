package me.giung.springboot.summoner.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.giung.springboot.summoner.entity.LeagueEntry;

@Getter
@Setter
@NoArgsConstructor
public class LeagueEntryDTO {

    String leagueId;

    String summonerId;

    String summonerName;

    String queueType;

    String tier;

    String rank;

    int leaguePoints;

    int wins;

    int losses;

    boolean hotStreak;

    boolean veteran;

    boolean freshBlood;

    boolean inactive;

    public LeagueEntry toEntity() {
        return LeagueEntry.builder().leagueId(leagueId).summonerId(summonerId).summonerName(summonerName)
                .queueType(queueType).tier(tier).rank(rank).leaguePoints(leaguePoints).wins(wins).losses(losses)
                .hotStreak(hotStreak).veteran(veteran).freshBlood(freshBlood).inactive(inactive).build();
    }

}