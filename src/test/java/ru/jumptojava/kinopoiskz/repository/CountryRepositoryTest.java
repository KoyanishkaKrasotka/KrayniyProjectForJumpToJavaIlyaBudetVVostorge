package ru.jumptojava.kinopoiskz.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.jumptojava.kinopoiskz.KinoPoiskZApplication;
import ru.jumptojava.kinopoiskz.entity.Country;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@ContextConfiguration(classes = {KinoPoiskZApplication.class, CountryRepositoryTest.TestCacheConfig.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CountryRepositoryTest {

    @TestConfiguration
    static class TestCacheConfig {
        @Bean
        CacheManager cacheManager() {
            return new ConcurrentMapCacheManager();
        }
    }

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void findByName_whenExists_returnsСountry() {
        countryRepository.save(new Country("Russia"));
        assertEquals(new Country("Russia"), countryRepository.findByName("Russia").get());
    }

    @Test
    void findByName_whenNotExists_returnsEmpty() {
        Optional<Country> country = countryRepository.findByName("Russia");
        assertTrue(country.isEmpty());
    }
}