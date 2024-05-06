package ru.recreation.recreationassistant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.recreation.recreationassistant.entity.Dish;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    Optional<Dish> findByDishLabel(String dishLabel);


}
