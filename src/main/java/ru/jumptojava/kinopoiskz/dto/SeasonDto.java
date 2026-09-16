package ru.jumptojava.kinopoiskz.dto;

import java.util.List;

public class SeasonDto {

    private Integer number;

    private List<Episode> episodes;

    public SeasonDto() {
    }

    public SeasonDto(Integer number, List<Episode> episodes) {
        this.number = number;
        this.episodes = episodes;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}
