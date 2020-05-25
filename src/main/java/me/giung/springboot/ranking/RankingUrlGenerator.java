package me.giung.springboot.ranking;

import org.springframework.stereotype.Service;

import me.giung.springboot.enums.ApiType;
import me.giung.springboot.enums.GameType;
import me.giung.springboot.enums.Version;
import me.giung.springboot.enums.QueueType;
import me.giung.springboot.enums.RankingUrl;

@Service
public class RankingUrlGenerator {

    /// /lol/league/v4/challengerleagues/by-queue/{queue}
    public String generateRankingApiUrlForChallenger() {
        return getUrlByTier(RankingUrl.CHALLENGER_LEAGUE);
    }

    public String generateRankingApiUrlForGrandMaster() {
        return getUrlByTier(RankingUrl.GRANDMASTER_LEAGUE);
    }

    public String generateRankingApiUrlForMaster() {
        return getUrlByTier(RankingUrl.MASTER_LEAGUE);
    }

    public String getUrlByTier(RankingUrl rankingUrl) {
        StringBuilder sb = new StringBuilder();

        sb.append("/");
        sb.append(GameType.LOL.getValue());
        sb.append("/");
        sb.append(ApiType.LEAGUE.getValue());
        sb.append("/");
        sb.append(Version.V4.getValue());
        sb.append("/");
        sb.append(rankingUrl.getValue());
        sb.append("/");
        sb.append(QueueType.RANKED_SOLO_5X5.getValue());

        return sb.toString();
    }

}