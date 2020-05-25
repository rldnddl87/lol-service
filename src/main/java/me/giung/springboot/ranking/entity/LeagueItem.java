package me.giung.springboot.ranking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.giung.springboot.entity.BaseTimeEntity;
import me.giung.springboot.enums.DivisionType;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeagueItem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEAGUE_ITEM_ID")
    private Long id;

    private boolean freshBlood;

    private int wins;

    private String summonerName;

    private boolean inactive;

    private boolean veteran;

    private boolean hotStreak;

    @Enumerated(EnumType.STRING)
    private DivisionType rank;

    private int leaguePoints;

    private int losses;

    private String summonerId;

    @ManyToOne
    @JoinColumn(name = "LEAGUE_LIST_ID")
    private LeagueList leagueList;

    public void setLeagueList(LeagueList list) {
        this.leagueList = list;
        if (!leagueList.getEntries().contains(this)) {
            leagueList.getEntries().add(this);
        }
    }

    @Builder
    public LeagueItem(boolean freshBlood, int wins, String summonerName, boolean inactive, boolean veteran,
            boolean hotStreak, DivisionType rank, int leaguePoints, int losses, String summonerId) {

        this.freshBlood = freshBlood;
        this.wins = wins;
        this.summonerName = summonerName;
        this.inactive = inactive;
        this.veteran = veteran;
        this.hotStreak = hotStreak;
        this.rank = rank;
        this.leaguePoints = leaguePoints;
        this.losses = losses;
        this.summonerId = summonerId;
    }
}