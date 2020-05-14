package me.giung.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import me.giung.springboot.appConfig.RiotProperties;
import me.giung.springboot.ranking.RankingService;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    RiotProperties riotProperties;

    @Autowired
    RankingService rankingService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Current Api Key : " + riotProperties.getKey());
        // System.out.println(QueueType.valueOf("RANKED_SOLO_5x5").getValue());
    }

}