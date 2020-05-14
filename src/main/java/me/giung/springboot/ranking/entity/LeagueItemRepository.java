package me.giung.springboot.ranking.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueItemRepository extends JpaRepository<LeagueItem, Long> {

}