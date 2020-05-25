package me.giung.springboot.ranking;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.giung.springboot.ranking.dto.LeagueItemDTO;

@RestController
@AllArgsConstructor
public class RankingRestController {

    RankingService rankingService;

    @GetMapping("/save1")
    public void get() {
        rankingService.saveChallengerRanking();
    }

    @GetMapping("/save2")
    public void get2() {
        rankingService.saveGrandMasterRanking();
    }

    @GetMapping("/save3")
    public void get3() {
        rankingService.saveMasterRanking();
    }

    @GetMapping("/find1")
    public List<LeagueItemDTO> find() {
        return rankingService.getChallengerRanking();
    }

    @GetMapping("/find2")
    public List<LeagueItemDTO> find2() {
        return rankingService.getGrandMasterRanking();
    }

    @GetMapping("/find3")
    public List<LeagueItemDTO> find3() {
        return rankingService.getMasterRanking();
    }
}