package ru.jumptojava.kinopoiskz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RedisCacheConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10))
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(
                                GenericJacksonJsonRedisSerializer.builder().enableUnsafeDefaultTyping().build()
                        ));
        Map<String, RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>();
        cacheConfigurationMap.put("staff", config.entryTtl(Duration.ofDays(1)));
        cacheConfigurationMap.put("images", config.entryTtl(Duration.ofDays(1)));
        cacheConfigurationMap.put("seasons", config.entryTtl(Duration.ofDays(1)));
        cacheConfigurationMap.put("similarFilms", config.entryTtl(Duration.ofDays(1)));
        cacheConfigurationMap.put("collections", config.entryTtl(Duration.ofDays(1)));
        cacheConfigurationMap.put("reviews", config.entryTtl(Duration.ofMinutes(5)));
        cacheConfigurationMap.put("premiers", config.entryTtl(Duration.ofDays(1)));
         return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                 .withInitialCacheConfigurations(cacheConfigurationMap)
                .build();
    }
}
