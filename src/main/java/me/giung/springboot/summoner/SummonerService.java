package me.giung.springboot.summoner;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import me.giung.springboot.summoner.dto.LeagueEntryDTO;
import me.giung.springboot.summoner.dto.SummonerDTO;
import me.giung.springboot.summoner.entity.LeagueEntry;
import me.giung.springboot.summoner.entity.LeagueEntryRepository;
import me.giung.springboot.summoner.entity.Summoner;
import me.giung.springboot.summoner.entity.SummonerRepository;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SummonerService {

    SummonerUrlGenerator urlGenerator;

    WebClient.Builder webClientBuilder;

    SummonerRepository summonerRepository;

    LeagueEntryRepository leagueEntryRepository;

    public SummonerDTO getSummoner(String summonerName) {
        Optional<Summoner> findSummoner = findSummoner(summonerName);

        SummonerDTO summonerDTO = null;

        if (!findSummoner.isPresent()) {
            summonerDTO = saveSummoner(summonerName);
        } else {
            Summoner summoner = findSummoner.get();
            summonerDTO.setAccountId(summoner.getAccountId());
            summonerDTO.setId(summoner.getId());
            summonerDTO.setName(summoner.getName());
            summonerDTO.setProfileIconId(summoner.getProfileIconId());
            summonerDTO.setPuuId(summoner.getPuuId());
            summonerDTO.setRevisionDate(summoner.getRevisionDate());
            summonerDTO.setSummonerLevel(summoner.getSummonerLevel());
        }
        return summonerDTO;
    }

    public SummonerDTO saveSummoner(String summonerName) {
        WebClient client = webClientBuilder.build();

        Mono<SummonerDTO> result = client.get().uri(urlGenerator.generateSummonerApiUrl(summonerName)).retrieve()
                .bodyToMono(SummonerDTO.class);

        SummonerDTO summonerDTO = result.block();

        summonerRepository.save(summonerDTO.toEntity());

        return summonerDTO;
    }

    public Optional<Summoner> findSummoner(String summonerName) {
        Optional<Summoner> findSummoner = summonerRepository.findByName(summonerName);
        return findSummoner;
    }

    // 조회 db 들림
    public LeagueEntryDTO getSummonerEntry(String summonerId) {
        Optional<LeagueEntry> entry = leagueEntryRepository.findBySummonerId(summonerId);

        LeagueEntryDTO dto = null;

        if (entry.isPresent()) {
            dto = leagueEntryEntityToDTO(entry.get());
        } else {
            dto = updateSummonerEntry(summonerId);
        }

        return dto;
    }

    // update
    public LeagueEntryDTO updateSummonerEntry(String summonerId) {
        WebClient client = webClientBuilder.build();

        Mono<LeagueEntryDTO> result = client.get().uri(urlGenerator.generateSummonerEntryApiUrl(summonerId)).retrieve()
                .bodyToMono(LeagueEntryDTO.class);

        LeagueEntryDTO dto = result.block();

        leagueEntryRepository.save(dto.toEntity());

        return dto;
    }

    public LeagueEntryDTO leagueEntryEntityToDTO(LeagueEntry leagueEntry) {
        LeagueEntryDTO dto = new LeagueEntryDTO();
        dto.setFreshBlood(leagueEntry.isFreshBlood());
        dto.setHotStreak(leagueEntry.isHotStreak());
        dto.setInactive(leagueEntry.isInactive());
        dto.setLeagueId(leagueEntry.getLeagueId());
        dto.setLeaguePoints(leagueEntry.getLeaguePoints());
        dto.setLosses(leagueEntry.getLosses());
        dto.setQueueType(leagueEntry.getQueueType());
        dto.setRank(leagueEntry.getRank());
        dto.setSummonerId(leagueEntry.getSummonerId());
        dto.setSummonerName(leagueEntry.getSummonerName());
        dto.setTier(leagueEntry.getTier());
        dto.setVeteran(leagueEntry.isVeteran());
        dto.setWins(leagueEntry.getWins());

        return dto;
    }
}