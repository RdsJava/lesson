package com.example.lesson.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // добаляет геттеры и сеттеры
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;

}
