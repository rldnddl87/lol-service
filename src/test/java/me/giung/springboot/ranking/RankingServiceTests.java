package me.giung.springboot.ranking;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import me.giung.springboot.appConfig.RiotProperties;
import me.giung.springboot.enums.BaseUrl;
import me.giung.springboot.ranking.entity.LeagueListRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.config.location = file:/app/config/app-config.yml" })
public class RankingServiceTests {

    @Autowired
    RiotProperties riotProperties;

    @Autowired
    RankingService rankingService;

    @Autowired
    UrlGenerater urlGenerater;

    @Autowired
    LeagueListRepository leagueListRepository;

    // Riot API와 정상적인 통신이 이루어젔는지 HttpStatus 200 확인한다.
    @Test
    public void saveChallengerRankingTest() throws ClientProtocolException, IOException {

        String baseUrl = BaseUrl.BASE_KOR.getValue() + "/" + urlGenerater.generateRankingApiUrlForChallenger();

        // given
        HttpUriRequest request = new HttpGet(baseUrl);
        request.addHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        request.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        request.addHeader("X-Riot-Token", riotProperties.getKey());

        // when
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        // then
        assertThat(response.getStatusLine().getStatusCode(), is(HttpStatus.SC_OK));

    }
}