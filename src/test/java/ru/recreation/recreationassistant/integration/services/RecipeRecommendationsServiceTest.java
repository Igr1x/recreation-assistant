package ru.recreation.recreationassistant.integration.services;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import ru.recreation.recreationassistant.entity.*;
import ru.recreation.recreationassistant.models.Recipe;
import ru.recreation.recreationassistant.services.RecipeRecommendationsService;
import ru.recreation.recreationassistant.services.TranslationService;
import ru.recreation.recreationassistant.services.impl.RestTemplateWork;

import java.util.List;
import java.util.Set;

@SpringBootTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class RecipeRecommendationsServiceTest {
    private final RecipeRecommendationsService service;
    private final TranslationService translationService;
    private final RestTemplateWork restTemplateWork;

    @Test
    void serviceRequestTest() {
        User user = new User("username", "chatId");
        user.setHealthTags(Set.of());
        user.setDishTags(Set.of());
        user.setCuisineTags(Set.of());
        user.setMealTags(Set.of());

        List<Recipe> recipeList = service.getRecipeRecommendations(user, "");
        Assertions.assertThat(recipeList).isEmpty();
    }
}
