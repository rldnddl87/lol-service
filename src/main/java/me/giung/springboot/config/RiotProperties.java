package me.giung.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("riot")
@Getter
@Setter
@Configuration
public class RiotProperties {

    private String key;

}