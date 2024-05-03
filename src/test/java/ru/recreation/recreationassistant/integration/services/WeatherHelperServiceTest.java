package ru.recreation.recreationassistant.integration.services;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import ru.recreation.recreationassistant.services.RecipientCoordinatesCity;
import ru.recreation.recreationassistant.services.WeatherHelperService;
import ru.recreation.recreationassistant.services.impl.RestTemplateWork;

import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class WeatherHelperServiceTest {
    private final WeatherHelperService weatherHelperService;
    private final RestTemplateWork restTemplateWork;
    private final RecipientCoordinatesCity recipientCoordinatesCity;

    @Test
    void weatherTest() {
        var city1 = recipientCoordinatesCity.getCoordinates("msk");
        var city2 = recipientCoordinatesCity.getCoordinates("spb");
        var city3 = recipientCoordinatesCity.getCoordinates("kzn");
        assertAll(() -> {
            Assertions.assertThat(weatherHelperService.getRecommendation(city1)).isNotEmpty();
            Assertions.assertThat(weatherHelperService.getRecommendation(city2)).isNotEmpty();
            Assertions.assertThat(weatherHelperService.getRecommendation(city3)).isNotEmpty();
        });
    }
}
