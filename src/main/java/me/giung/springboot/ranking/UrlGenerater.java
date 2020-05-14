package me.giung.springboot.ranking;

import org.springframework.stereotype.Service;

import me.giung.springboot.enums.ApiType;
import me.giung.springboot.enums.GameType;
import me.giung.springboot.enums.Version;
import me.giung.springboot.enums.QueueType;
import me.giung.springboot.enums.RankingUrl;

@Service
public class UrlGenerater {

    /// lol/league/v4/challengerleagues/by-queue/{queue}
    public String generateRankingApiUrlForChallenger() {
        StringBuilder sb = new StringBuilder();

        sb.append("/");
        sb.append(GameType.LOL.getValue());
        sb.append("/");
        sb.append(ApiType.LEAGUE.getValue());
        sb.append("/");
        sb.append(Version.V4.getValue());
        sb.append("/");
        sb.append(RankingUrl.CHALLENGER_LEAGUE.getValue());
        sb.append("/");
        sb.append(QueueType.RANKED_SOLO_5X5.getValue());

        return sb.toString();
    }

    public String generateRankingApiUrlForGrandMaster() {

        return null;
    }

    public String generateRankingApiUrlForMaster() {

        return null;
    }

    public String generateRankingApiUrlForDiamond() {
        return null;
    }

}