package com.rsi.backendowoce.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FruitDTO {
    @Schema(description = "Nazwa owocu", example = "Jabłko")
    private String name;

    @Schema(description = "Kolor owocu", example = "Zielony")
    private String color;

    @Schema(description = "Waga owocu w gramach", example = "500")
    private int weight;

    @Schema(description = "Cena owocu", example = "3.99")
    private double price;
}
