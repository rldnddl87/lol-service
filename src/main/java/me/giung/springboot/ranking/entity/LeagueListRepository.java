package me.giung.springboot.ranking.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.giung.springboot.enums.TierType;

@Repository
public interface LeagueListRepository extends JpaRepository<LeagueList, Long> {

    List<LeagueList> findByTier(TierType tier);
}