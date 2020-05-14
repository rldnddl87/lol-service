package me.giung.springboot.ranking.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.giung.springboot.entity.BaseTimeEntity;
import me.giung.springboot.enums.QueueType;
import me.giung.springboot.enums.TierType;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LeagueList extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEAGUE_LIST_ID")
    private Long id;

    private String leagueId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "leagueList", cascade = CascadeType.ALL)
    private List<LeagueItem> entries = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private TierType tier;

    private String name;

    @Enumerated(EnumType.STRING)
    private QueueType queue;

    public void addEntries(LeagueItem item) {
        this.entries.add(item);
        if (item.getLeagueList() != this) {
            item.setLeagueList(this);
        }
    }

    @Builder
    public LeagueList(String leagueId, TierType tier, String name, QueueType queue) {
        this.leagueId = leagueId;
        this.tier = tier;
        this.name = name;
        this.queue = queue;
    }

}