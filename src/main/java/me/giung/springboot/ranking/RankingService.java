package me.giung.springboot.ranking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import me.giung.springboot.appConfig.RiotProperties;
import me.giung.springboot.enums.TierType;
import me.giung.springboot.ranking.dto.LeagueItemDTO;
import me.giung.springboot.ranking.dto.LeagueListDTO;
import me.giung.springboot.ranking.entity.LeagueItem;
import me.giung.springboot.ranking.entity.LeagueList;
import me.giung.springboot.ranking.entity.LeagueListRepository;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RankingService {

    UrlGenerater urlGenerater;

    RiotProperties riotProperties;

    WebClient.Builder webClientBuilder;

    LeagueListRepository leagueListRepository;

    // 추후에 배치작업으로 빼야한다.
    // Riot API를 통해 챌린저 랭커들 목록을 가져온다음 DB에 저장한다.
    public void saveChallengerRanking() {
        WebClient client = webClientBuilder.build();
        LeagueListDTO leagueListDTO;

        Mono<LeagueListDTO> result = client.get().uri(urlGenerater.generateRankingApiUrlForChallenger()).retrieve()
                .bodyToMono(LeagueListDTO.class);

        leagueListDTO = result.block();

        leagueListRepository.save(leagueListDTO.toEntity());

    }

    // 저장된 랭킹을 가져온다.
    public List<LeagueItemDTO> getChallengerRanking() {

        List<LeagueList> leagueList = leagueListRepository.findByTier(TierType.CHALLENGER);

        LeagueList challengerLeagueList = leagueList.get(0);

        return ListToItemDTO(challengerLeagueList);
    }

    public List<LeagueItemDTO> ListToItemDTO(LeagueList leagueList) {

        List<LeagueItem> challengerLeagueItem = leagueList.getEntries();

        List<LeagueItemDTO> leagueItemDTOList = new ArrayList<>();

        for (LeagueItem item : challengerLeagueItem) {
            LeagueItemDTO dto = new LeagueItemDTO();
            dto.setFreshBlood(item.isFreshBlood());
            dto.setWins(item.getWins());
            dto.setSummonerName(item.getSummonerName());
            dto.setInactive(item.isInactive());
            dto.setVeteran(item.isVeteran());
            dto.setHotStreak(item.isHotStreak());
            dto.setRank(item.getRank().getValue());
            dto.setLeaguePoints(item.getLeaguePoints());
            dto.setLosses(item.getLosses());
            dto.setSummonerId(item.getSummonerId());
            leagueItemDTOList.add(dto);
        }

        sortByLeaguePoint(leagueItemDTOList);

        return leagueItemDTOList;
    }

    public List<LeagueItemDTO> sortByLeaguePoint(List<LeagueItemDTO> list) {
        Collections.sort(list, new Comparator<LeagueItemDTO>() {

            @Override
            public int compare(LeagueItemDTO o1, LeagueItemDTO o2) {
                return o2.getLeaguePoints() - o1.getLeaguePoints();
            }

        });

        return list;
    }

}