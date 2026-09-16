package ru.jumptojava.kinopoiskz.dto;

import java.util.List;

public class SearchByKeywordResponse {

    private String keyword;

    private Integer pagesCount;

    private Integer searchFilmsCountResult;

    private List<SearchByKeywordDto> films;

    public SearchByKeywordResponse() {
    }

    public SearchByKeywordResponse(String keyword, Integer pagesCount, Integer searchFilmsCountResult, List<SearchByKeywordDto> films) {
        this.keyword = keyword;
        this.pagesCount = pagesCount;
        this.searchFilmsCountResult = searchFilmsCountResult;
        this.films = films;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(Integer pagesCount) {
        this.pagesCount = pagesCount;
    }

    public Integer getSearchFilmsCountResult() {
        return searchFilmsCountResult;
    }

    public void setSearchFilmsCountResult(Integer searchFilmsCountResult) {
        this.searchFilmsCountResult = searchFilmsCountResult;
    }

    public List<SearchByKeywordDto> getFilms() {
        return films;
    }

    public void setFilms(List<SearchByKeywordDto> films) {
        this.films = films;
    }
}
