package me.giung.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import me.giung.springboot.config.RiotProperties;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    RiotProperties riotProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==========================================================");
        System.out.println(riotProperties.getKey());
    }

}