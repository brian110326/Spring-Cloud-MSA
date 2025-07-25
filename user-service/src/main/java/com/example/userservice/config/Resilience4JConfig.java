package com.example.userservice.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4JConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {

        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(4) // 100번 중 4번 실패하면 OPEN 상태로 전환(Circuit Breaker가 발동)
                .waitDurationInOpenState(Duration.ofMillis(1000)) //OPEN 상태일때 1초후 다시
                //HALF_OPEN 상태로 전환하여 요청 허용
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                //요청개수 기반
                .slidingWindowSize(2)//마지막 2개 요청을 기준으로 실패율 계산
                .build();

        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(4)) //4초 이상걸리면 타임아웃예외 발생
                .build();

        return factory -> factory.configureDefault(
                id -> new Resilience4JConfigBuilder(id)
                        .timeLimiterConfig(timeLimiterConfig)
                        .circuitBreakerConfig(circuitBreakerConfig)
                        .build()
        );
    }

}
