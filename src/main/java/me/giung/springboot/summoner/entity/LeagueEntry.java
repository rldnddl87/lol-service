package me.giung.springboot.summoner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeagueEntry {

    @Id
    @Column(name = "LEAGUE_ENTRY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

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

    @Builder
    public LeagueEntry(String leagueId, String summonerId, String summonerName, String queueType, String tier,
            String rank, int leaguePoints, int wins, int losses, boolean hotStreak, boolean veteran, boolean freshBlood,
            boolean inactive) {
        this.leagueId = leagueId;
        this.summonerId = summonerId;
        this.summonerName = summonerName;
        this.queueType = queueType;
        this.tier = tier;
        this.rank = rank;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        this.hotStreak = hotStreak;
        this.veteran = veteran;
        this.freshBlood = freshBlood;
        this.inactive = inactive;
    }

}