package ru.jumptojava.kinopoiskz.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.jumptojava.kinopoiskz.dto.FilmResponse;
import java.net.URI;

import java.nio.charset.StandardCharsets;

@Service
public class KinopoiskClientService {

    private final RestTemplate restTemplate;

    @Value("${kinopoisk.api.token}")
    private String kinopoiskApiToken;

    @Value("${kinopoisk.api.url}")
    private String kinopoiskUrl;

    public KinopoiskClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FilmResponse getFilms(Integer countries, Integer genres, String order, String type,
                                 Float ratingFrom, Float ratingTo,
                                 Integer yearFrom, Integer yearTo,
                                 String keyword, Integer page) {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(kinopoiskUrl + "/api/v2.2/films");

        if (countries != null) {
            builder.queryParam("countries", countries);
        }
        if (genres != null) {
            builder.queryParam("genres", genres);
        }
        if (order != null) {
            builder.queryParam("order", order);
        }
        if (type != null) {
            builder.queryParam("type", type);
        }
        if (ratingFrom != null) {
            builder.queryParam("ratingFrom", ratingFrom);
        }
        if (ratingTo != null) {
            builder.queryParam("ratingTo", ratingTo);
        }
        if (yearFrom != null) {
            builder.queryParam("yearFrom", yearFrom);
        }
        if (yearTo != null) {
            builder.queryParam("yearTo", yearTo);
        }
        if (keyword != null) {
            builder.queryParam("keyword", keyword);
        }
        if (page != null) {
            builder.queryParam("page", page);
        }

        URI uri = builder.build().encode(StandardCharsets.UTF_8).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", kinopoiskApiToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<FilmResponse> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    FilmResponse.class
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Не удалось получить данные от Кинопоиска - " + e.getMessage(), e);
        }
    }
}