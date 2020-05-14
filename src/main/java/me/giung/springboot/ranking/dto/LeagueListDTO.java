package me.giung.springboot.ranking.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.giung.springboot.enums.QueueType;
import me.giung.springboot.enums.TierType;
import me.giung.springboot.ranking.entity.LeagueItem;
import me.giung.springboot.ranking.entity.LeagueList;

@Getter
@Setter
@NoArgsConstructor
public class LeagueListDTO {

    private String leagueId;

    private List<LeagueItemDTO> entries;

    private String tier;

    private String name;

    private String queue;

    public LeagueList toEntity() {
        LeagueList leagueList = LeagueList.builder().leagueId(leagueId).tier(TierType.findByString(tier)).name(name)
                .queue(QueueType.findByString(queue)).build();
        List<LeagueItem> leagueItemList = getEntityList(entries);
        for (LeagueItem item : leagueItemList) {
            leagueList.addEntries(item);
        }
        return leagueList;
    }

    private List<LeagueItem> getEntityList(List<LeagueItemDTO> dto) {
        List<LeagueItem> list = new ArrayList<>();
        for (LeagueItemDTO item : dto) {
            list.add(item.toEntity());
        }
        return list;
    }

}