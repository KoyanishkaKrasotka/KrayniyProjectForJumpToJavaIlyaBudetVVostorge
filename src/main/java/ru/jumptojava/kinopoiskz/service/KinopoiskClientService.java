package ru.jumptojava.kinopoiskz.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.jumptojava.kinopoiskz.dto.*;
import ru.jumptojava.kinopoiskz.dto.enums.CollectionType;
import ru.jumptojava.kinopoiskz.dto.enums.ImageType;
import ru.jumptojava.kinopoiskz.dto.enums.PremiereMonth;
import ru.jumptojava.kinopoiskz.dto.enums.ReviewOrder;

import java.net.URI;

import java.nio.charset.StandardCharsets;
import java.util.List;

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


    private FilmResponse filmsFallback(Integer countries, Integer genres, String order, String type,
                                       Float ratingFrom, Float ratingTo,
                                       Integer yearFrom, Integer yearTo,
                                       String keyword, Integer page, Throwable t) {
        throw  new RuntimeException("Внешний сервис Кинопоиска недоступен: " + t.getMessage());
    }

    @CircuitBreaker(name = "kinopoiskApi", fallbackMethod = "filmsFallback")
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

    private SimilarFilmResponse similarFallback(Integer id, Throwable t) {
        throw  new RuntimeException("Внешний сервис Кинопоиска недоступен: " + t.getMessage());
    }

    @Cacheable(cacheNames = "similarFilms", key = "#id")
    @CircuitBreaker(name = "kinopoiskApi", fallbackMethod = "similarFallback")
    public SimilarFilmResponse getSimilarFilms(Integer id) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(kinopoiskUrl + "/api/v2.2/films/{id}/similars");
        URI uri = builder.buildAndExpand(id).encode(StandardCharsets.UTF_8).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", kinopoiskApiToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<SimilarFilmResponse> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    SimilarFilmResponse.class
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Не удалось получить данные от Кинопоиска - " + e.getMessage(), e);
        }
    }

    private ReviewResponse reviewsFallback(Integer id,Integer page, ReviewOrder order, Throwable t) {
        throw  new RuntimeException("Внешний сервис Кинопоиска недоступен: " + t.getMessage());
    }

    @Cacheable(cacheNames = "reviews", key = "#id + '_' + #page + '_' + #order")
    @CircuitBreaker(name = "kinopoiskApi", fallbackMethod = "reviewsFallback")
    public ReviewResponse getReviews(Integer id,Integer page, ReviewOrder order) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(kinopoiskUrl + "/api/v2.2/films/{id}/reviews");
        if (page != null) {
            builder.queryParam("page", page);
        }

        if (order != null) {
            builder.queryParam("order", order.getOrderValue());
        }
        URI uri = builder.buildAndExpand(id).encode(StandardCharsets.UTF_8).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", kinopoiskApiToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<ReviewResponse> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    ReviewResponse.class
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Не удалось получить данные от Кинопоиска - " + e.getMessage(), e);
        }
    }

    private List<StaffItem> staffFallback(Integer filmId, Throwable t) {
        throw  new RuntimeException("Внешний сервис Кинопоиска недоступен: " + t.getMessage());
    }

    @Cacheable(cacheNames = "staff", key = "#filmId")
    @CircuitBreaker(name = "kinopoiskApi", fallbackMethod = "staffFallback")
    public List<StaffItem> getStaff(Integer filmId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(kinopoiskUrl + "/api/v1/staff");

        builder.queryParam("filmId", filmId);
        URI uri = builder.build().encode(StandardCharsets.UTF_8).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", kinopoiskApiToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<List<StaffItem>> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<List<StaffItem>>() {}
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Не удалось получить данные от Кинопоиска - " + e.getMessage(), e);
        }
    }

    private FilmFullInfo filmsByIdFallback(Integer id, Throwable t) {
        throw  new RuntimeException("Внешний сервис Кинопоиска недоступен: " + t.getMessage());
    }

    @CircuitBreaker(name = "kinopoiskApi", fallbackMethod = "filmsByIdFallback")
    public FilmFullInfo getFilmById(Integer id) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(kinopoiskUrl + "/api/v2.2/films/{id}");
        URI uri = builder.buildAndExpand(id).encode(StandardCharsets.UTF_8).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", kinopoiskApiToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<FilmFullInfo> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    FilmFullInfo.class
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Не удалось получить данные от Кинопоиска - " + e.getMessage(), e);
        }
    }

    private SeasonsResponse seasonsFallback(Integer id, Throwable t) {
        throw  new RuntimeException("Внешний сервис Кинопоиска недоступен: " + t.getMessage());
    }

    @Cacheable(cacheNames = "seasons", key = "#id")
    @CircuitBreaker(name = "kinopoiskApi", fallbackMethod = "seasonsFallback")
    public SeasonsResponse getSeasons(Integer id) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(kinopoiskUrl + "/api/v2.2/films/{id}/seasons");
        URI uri = builder.buildAndExpand(id).encode(StandardCharsets.UTF_8).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", kinopoiskApiToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<SeasonsResponse> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    SeasonsResponse.class
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Не удалось получить данные от Кинопоиска - " + e.getMessage(), e);
        }
    }

    private ImageResponse imageFallback(Integer id, Integer page, ImageType type, Throwable t) {
        throw  new RuntimeException("Внешний сервис Кинопоиска недоступен: " + t.getMessage());
    }

    @Cacheable(cacheNames = "images", key = "#id + '_' + #page + '_' + #type")
    @CircuitBreaker(name = "kinopoiskApi", fallbackMethod = "imageFallback")
    public ImageResponse getImage(Integer id, Integer page, ImageType type) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(kinopoiskUrl + "/api/v2.2/films/{id}/images");

        if (page != null) {
            builder.queryParam("page", page);
        }

        if (type != null) {
            builder.queryParam("type", type.getTypeValue());
        }

        URI uri = builder.buildAndExpand(id).encode(StandardCharsets.UTF_8).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", kinopoiskApiToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<ImageResponse> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    ImageResponse.class
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Не удалось получить данные от Кинопоиска - " + e.getMessage(), e);
        }
    }
    private PremiereResponse premiereFallback(Integer year, PremiereMonth month, Throwable t) {
        throw  new RuntimeException("Внешний сервис Кинопоиска недоступен: " + t.getMessage());
    }

    @Cacheable(cacheNames = "premiers", key = "#year + '_' + #month")
    @CircuitBreaker(name = "kinopoiskApi", fallbackMethod = "premiereFallback")
    public PremiereResponse getPremieres(Integer year, PremiereMonth month) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(kinopoiskUrl + "/api/v2.2/films/premieres");

        if (year != null) {
            builder.queryParam("year", year);
        }

        if (month != null) {
            builder.queryParam("month", month.getMonthValue());
        }

        URI uri = builder.build().encode(StandardCharsets.UTF_8).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", kinopoiskApiToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<PremiereResponse> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    PremiereResponse.class
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Не удалось получить данные от Кинопоиска - " + e.getMessage(), e);
        }

    }
    private CollectionResponse collectionsFallback(CollectionType type, Integer page, Throwable t) {
        throw  new RuntimeException("Внешний сервис Кинопоиска недоступен: " + t.getMessage());
    }

    @Cacheable(cacheNames = "collections", key = "#type + '_' + #page")
    @CircuitBreaker(name = "kinopoiskApi", fallbackMethod = "collectionsFallback")
    public CollectionResponse getCollections(CollectionType type, Integer page) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(kinopoiskUrl + "/api/v2.2/films/collections");

        if (type != null) {
            builder.queryParam("type", type.getCollectionValue());
        }

        if (page != null) {
            builder.queryParam("page", page);
        }
        URI uri = builder.build().encode(StandardCharsets.UTF_8).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", kinopoiskApiToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<CollectionResponse> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    CollectionResponse.class
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Не удалось получить данные от Кинопоиска - " + e.getMessage(), e);
        }
    }

    private SearchByKeywordResponse filmsByKeywordsFallback(String keyword, Integer page, Throwable t) {
            throw  new RuntimeException("Внешний сервис Кинопоиска недоступен: " + t.getMessage());
    }

    @CircuitBreaker(name = "kinopoiskApi", fallbackMethod = "filmsByKeywordsFallback")
    public SearchByKeywordResponse getFilmsByKeyword(String keyword, Integer page) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(kinopoiskUrl + "/api/v2.1/films/search-by-keyword");

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
            ResponseEntity<SearchByKeywordResponse> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    SearchByKeywordResponse.class
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Не удалось получить данные от Кинопоиска - " + e.getMessage(), e);
        }
    }

}