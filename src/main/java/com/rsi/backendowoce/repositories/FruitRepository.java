package com.rsi.backendowoce.repositories;

import com.rsi.backendowoce.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
    boolean existsByNameAndColorAndWeightAndPrice(String name, String color, int weight, double price);
}
