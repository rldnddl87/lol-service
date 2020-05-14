package me.giung.springboot.ranking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.giung.springboot.enums.DivisionType;
import me.giung.springboot.ranking.entity.LeagueItem;

@Getter
@Setter
@NoArgsConstructor
public class LeagueItemDTO {
    private boolean freshBlood;

    private int wins;

    private String summonerName;

    private boolean inactive;

    private boolean veteran;

    private boolean hotStreak;

    private String rank;

    private int leaguePoints;

    private int losses;

    private String summonerId;

    public LeagueItem toEntity() {
        return LeagueItem.builder().freshBlood(freshBlood).wins(wins).summonerName(summonerName).inactive(inactive)
                .veteran(veteran).hotStreak(hotStreak).rank(DivisionType.findByString(rank)).leaguePoints(leaguePoints)
                .losses(losses).summonerId(summonerId).build();
    }

}