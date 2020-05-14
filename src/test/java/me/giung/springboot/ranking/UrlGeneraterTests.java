package me.giung.springboot.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlGeneraterTests {

    @Autowired
    UrlGenerater urlGenerator;

    @Test
    public void generateRankingApiUrlForChallengerTest() {
        String expected = "/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5";

        assertEquals(expected, urlGenerator.generateRankingApiUrlForChallenger());
    }
}