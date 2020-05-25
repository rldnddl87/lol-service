package me.giung.springboot.summoner.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummonerRepository extends JpaRepository<Summoner, Long> {

    Optional<Summoner> findByName(String summonerName);
}