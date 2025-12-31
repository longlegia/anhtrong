package com.example.demo.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @Column(name = "id", length = 36, columnDefinition = "CHAR(36)")
    String id;

    @Column(name = "name", columnDefinition = "VARCHAR(350) COLLATE utf8mb4_general_ci")
    String name;

    @Column(name = "price", precision = 10, scale = 2)
    BigDecimal price;

    @Column(name = "thumbnail", columnDefinition = "VARCHAR(255)")
    String thumbnail;

    @Column(name = "description", columnDefinition = "LONGTEXT COLLATE utf8mb4_general_ci")
    String description;

    @Column(name = "created_at")
    LocalDate createdAt;

    @Column(name = "updated_at")
    LocalDate updatedAt;
}