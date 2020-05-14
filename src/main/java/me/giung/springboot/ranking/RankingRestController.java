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

    @GetMapping("/get")
    public void get() {
        rankingService.saveChallengerRanking();
    }

    @GetMapping("/find")
    public List<LeagueItemDTO> find() {
        return rankingService.getChallengerRanking();
    }
}