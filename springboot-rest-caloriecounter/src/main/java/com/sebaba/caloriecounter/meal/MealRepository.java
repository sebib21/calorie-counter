package com.sebaba.caloriecounter.meal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


interface MealRepository extends JpaRepository<Meal, Long> {

    public List<Meal> findByMealDateAndPersonPersonId(LocalDate mealDate, Long personId);
    
}