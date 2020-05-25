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
public class Summoner {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long summonerId;

    @Column(name = "SUMMONER_ID")
    String id;

    String accountId;

    int profileIconId;

    long revisionDate;

    String name;

    String puuId;

    long summonerLevel;

    @Builder
    public Summoner(String id, String accountId, int profileIconId, long revisionDate, String name, String puuId,
            long summonerLevel) {
        this.id = id;
        this.accountId = accountId;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.name = name;
        this.puuId = puuId;
        this.summonerLevel = summonerLevel;
    }

}