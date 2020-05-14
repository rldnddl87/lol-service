package me.giung.springboot.appConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import me.giung.springboot.enums.BaseUrl;

@Configuration
@EnableJpaAuditing
public class appConfig {

    @Autowired
    RiotProperties riotProperties;

    @Bean
    public WebClientCustomizer webClientCustomizer() {
        WebClientCustomizer customWebClientCustomizer = new WebClientCustomizer() {

            @Override
            public void customize(Builder webClientBuilder) {
                webClientBuilder.baseUrl(BaseUrl.BASE_KOR.getValue())
                        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .defaultHeader("X-Riot-Token", riotProperties.getKey());

            }
        };

        return customWebClientCustomizer;
    }
}