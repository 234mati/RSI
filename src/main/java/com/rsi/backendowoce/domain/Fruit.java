package com.rsi.backendowoce.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identyfikator owocu", example = "1")
    private long id;

    @Schema(description = "Nazwa owocu", example = "Jabłko")
    private String name;

    @Schema(description = "Kolor owocu", example = "Zielony")
    private String color;

    @Schema(description = "Waga owocu w gramach", example = "500")
    private int weight;

    @Schema(description = "Cena owocu", example = "3.99")
    private double price;

    @Builder
    public Fruit(String name, String color, int weight, double price) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

}
