package ru.recreation.recreationassistant.integration.services;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import ru.recreation.recreationassistant.entity.User;
import ru.recreation.recreationassistant.services.SearchEventService;
import ru.recreation.recreationassistant.services.impl.RestTemplateWork;

import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class SearchEventServiceTest {
    private final RestTemplateWork restTemplate;
    private final SearchEventService searchEventService;

    @Test
    void searchEventsTest() {
        User user = new User();
        user.setCity("msk");
        assertAll(() -> {
            Assertions.assertThat(searchEventService.getRecommendation(user, "clubs")).isNotEmpty();
            Assertions.assertThat(searchEventService.getRecommendation(user, "park")).isNotEmpty();
        });
        user.setCity("kzn");
        assertAll(() -> {
            Assertions.assertThat(searchEventService.getRecommendation(user, "museums")).isNotEmpty();
            Assertions.assertThat(searchEventService.getRecommendation(user, "culture")).isNotEmpty();
        });
    }

    @Test
    void cityWithoutEventsTest() {
        User user = new User();
        user.setCity("ufa");
        assertAll(() -> {
            Assertions.assertThat(searchEventService.getRecommendation(user, "culture")).isEmpty();
        });
    }
}
