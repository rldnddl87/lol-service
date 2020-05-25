package me.giung.springboot.summoner.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueEntryRepository extends JpaRepository<LeagueEntry, Long> {

    Optional<LeagueEntry> findBySummonerId(String summonerId);
}