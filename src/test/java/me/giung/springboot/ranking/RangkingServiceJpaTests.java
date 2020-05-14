package me.giung.springboot.ranking;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import me.giung.springboot.enums.DivisionType;
import me.giung.springboot.enums.QueueType;
import me.giung.springboot.enums.TierType;
import me.giung.springboot.ranking.dto.LeagueItemDTO;
import me.giung.springboot.ranking.dto.LeagueListDTO;
import me.giung.springboot.ranking.entity.LeagueItem;
import me.giung.springboot.ranking.entity.LeagueList;
import me.giung.springboot.ranking.entity.LeagueListRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RangkingServiceJpaTests {

    @Autowired
    LeagueListRepository repository;

    // jpa를 통한 insert & read 테스트
    @BeforeEach
    public void before() {
        // DTO setting
        LeagueItemDTO leagueItemDTO1 = new LeagueItemDTO();
        leagueItemDTO1.setFreshBlood(false);
        leagueItemDTO1.setHotStreak(false);
        leagueItemDTO1.setInactive(false);
        leagueItemDTO1.setLeaguePoints(1200);
        leagueItemDTO1.setLosses(250);
        leagueItemDTO1.setRank(DivisionType.I.getValue());
        leagueItemDTO1.setSummonerId("8jxRETJqeg1xknjgU_rlp7m_GKiN6p8ggu5t-lgSz7N7Ww");
        leagueItemDTO1.setSummonerName("챌린저랭커시다1");
        leagueItemDTO1.setVeteran(false);
        leagueItemDTO1.setWins(300);

        LeagueItemDTO leagueItemDTO2 = new LeagueItemDTO();
        leagueItemDTO2.setFreshBlood(false);
        leagueItemDTO2.setHotStreak(false);
        leagueItemDTO2.setInactive(false);
        leagueItemDTO2.setLeaguePoints(200);
        leagueItemDTO2.setLosses(25);
        leagueItemDTO2.setRank(DivisionType.I.getValue());
        leagueItemDTO2.setSummonerId("xnPZn5VNLMga2WLqYV0NmfZl0nXxevbsJhv2nSqU26ZpqaQ");
        leagueItemDTO2.setSummonerName("챌린저랭커시다2");
        leagueItemDTO2.setVeteran(false);
        leagueItemDTO2.setWins(30);

        List<LeagueItemDTO> entries = new ArrayList<>();
        entries.add(leagueItemDTO1);
        entries.add(leagueItemDTO2);

        LeagueListDTO leagueListDTO = new LeagueListDTO();

        leagueListDTO.setLeagueId("5cc4fe58-4e57-37f1-9dc3-7c32b2632923");
        leagueListDTO.setName("Hecarim's Snipers");
        leagueListDTO.setQueue(QueueType.RANKED_SOLO_5X5.getValue());
        leagueListDTO.setTier(TierType.CHALLENGER.getValue());

        leagueListDTO.setEntries(entries);

        // make entity from dto
        LeagueList leagueList = leagueListDTO.toEntity();

        // entity db insert and read
        repository.save(leagueList);
        System.out.println("========================");
        System.out.println("before db setup is ready");
        System.out.println("========================");
    }

    @Test
    public void getChallengerRankingTest() {

        List<LeagueList> leagueList = repository.findByTier(TierType.CHALLENGER);

        List<LeagueItem> itemList = leagueList.get(0).getEntries();

        // 리그 포인트 순으로 정렬한다.
        Collections.sort(itemList, new Comparator<LeagueItem>() {
            @Override
            public int compare(LeagueItem o1, LeagueItem o2) {
                return o2.getLeaguePoints() - o1.getLeaguePoints();
            }
        });

        LeagueItem item1 = itemList.get(0);
        LeagueItem item2 = itemList.get(1);

        assertThat(item1.isFreshBlood(), is(false));
        assertThat(item1.isHotStreak(), is(false));
        assertThat(item1.isInactive(), is(false));
        assertThat(item1.getLeaguePoints(), is(1200));
        assertThat(item1.getLosses(), is(250));
        assertThat(item1.getRank(), is(DivisionType.I));
        assertThat(item1.getSummonerId(), is("8jxRETJqeg1xknjgU_rlp7m_GKiN6p8ggu5t-lgSz7N7Ww"));
        assertThat(item1.getSummonerName(), is("챌린저랭커시다1"));
        assertThat(item1.isVeteran(), is(false));
        assertThat(item1.getWins(), is(300));

        assertThat(item2.isFreshBlood(), is(false));
        assertThat(item2.isHotStreak(), is(false));
        assertThat(item2.isInactive(), is(false));
        assertThat(item2.getLeaguePoints(), is(200));
        assertThat(item2.getLosses(), is(25));
        assertThat(item2.getRank(), is(DivisionType.I));
        assertThat(item2.getSummonerId(), is("xnPZn5VNLMga2WLqYV0NmfZl0nXxevbsJhv2nSqU26ZpqaQ"));
        assertThat(item2.getSummonerName(), is("챌린저랭커시다2"));
        assertThat(item2.isVeteran(), is(false));
        assertThat(item2.getWins(), is(30));

    }

}