package me.giung.springboot.summoner;

import org.springframework.stereotype.Service;

import me.giung.springboot.enums.ApiType;
import me.giung.springboot.enums.GameType;
import me.giung.springboot.enums.RankingUrl;
import me.giung.springboot.enums.SummonerUrl;
import me.giung.springboot.enums.Version;

@Service
public class SummonerUrlGenerator {
    // lol/summoner/v4/summoners/by-name/{summonerName}
    public String generateSummonerApiUrl(String summonerName) {
        StringBuilder sb = new StringBuilder();

        sb.append("/");
        sb.append(GameType.LOL.getValue());
        sb.append("/");
        sb.append(SummonerUrl.SUMMONER.getValue());
        sb.append("/");
        sb.append(Version.V4.getValue());
        sb.append("/");
        sb.append(SummonerUrl.SUMMONERS.getValue());
        sb.append("/");
        sb.append(SummonerUrl.BY_NAME.getValue());
        sb.append("/");
        sb.append(summonerName);

        return sb.toString();
    }

    // /lol/league/v4/entries/by-summoner/{encryptedSummonerId}
    public String generateSummonerEntryApiUrl(String summonerId) {
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        sb.append(GameType.LOL.getValue());
        sb.append("/");
        sb.append(ApiType.LEAGUE.getValue());
        sb.append("/");
        sb.append(Version.V4.getValue());
        sb.append("/");
        sb.append(RankingUrl.ENTRIES.getValue());
        sb.append("/");
        sb.append(SummonerUrl.BY_SUMMONER.getValue());
        sb.append("/");
        sb.append(summonerId);

        return sb.toString();
    }

}