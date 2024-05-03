package ru.recreation.recreationassistant.integration.services;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import ru.recreation.recreationassistant.services.RecipientCoordinatesCity;
import ru.recreation.recreationassistant.services.impl.RestTemplateWork;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class RecipientCoordinatesCityTest {
    private final RestTemplateWork restTemplateWork;
    private final RecipientCoordinatesCity recipientCoordinatesCity;

    @Test
    void getCoordinatesTest() {
        Assertions.assertAll(() -> {
            assertThat(recipientCoordinatesCity.getCoordinates("msk").getLatitude()).isEqualTo(55.755819);
            assertThat(recipientCoordinatesCity.getCoordinates("msk").getLongitude()).isEqualTo(37.617644);
            assertThat(recipientCoordinatesCity.getCoordinates("spb").getLatitude()).isEqualTo(59.938676);
            assertThat(recipientCoordinatesCity.getCoordinates("spb").getLongitude()).isEqualTo(30.314494);
            assertThat(recipientCoordinatesCity.getCoordinates("kzn").getLatitude()).isEqualTo(55.608094);
            assertThat(recipientCoordinatesCity.getCoordinates("kzn").getLongitude()).isEqualTo(49.2986);
        });
    }

}
