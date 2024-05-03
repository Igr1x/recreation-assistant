package ru.recreation.recreationassistant.integration.services;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import ru.recreation.recreationassistant.services.TranslationService;
import ru.recreation.recreationassistant.services.impl.RestTemplateWork;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class TranslationServiceTest {
    private final TranslationService translationService;
    private final RestTemplateWork restTemplateWork;

    @Test
    void emptyStringTest() {
        assertThrows(IllegalStateException.class, () -> translationService.translate(""));
    }

    @Test
    void translateTest() {
        assertAll(() -> {
           Assertions.assertThat(translationService.translate("hello")).isEqualTo("привет");
           Assertions.assertThat(translationService.translate("how")).isEqualTo("как");
           Assertions.assertThat(translationService.translate("big")).isEqualTo("большой");
            Assertions.assertThat(translationService.translate("Hello").toLowerCase()).isEqualTo("привет");
        });
    }

    @Test
    void incorrectInputTest() {
        assertAll(() -> {
            Assertions.assertThat(translationService.translate("Hi")).isNotEqualTo("Пока");
            Assertions.assertThat(translationService.translate("Mean")).isNotEqualTo("Привет");
            Assertions.assertThat(translationService.translate("Small")).isNotEqualTo("Большой");
        });
    }
}
