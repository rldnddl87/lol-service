package me.giung.springboot.appConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("riot")
@Configuration
public class RiotProperties {

    private String key;

}