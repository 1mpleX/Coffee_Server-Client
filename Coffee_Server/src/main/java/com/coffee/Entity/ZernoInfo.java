package com.coffee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "zerno_info")
public class ZernoInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "weight")
    private int weight;

    @Column(name = "country")
    private String country;

    @Column(name = "robust_persentage")
    private double robust_persentage;

    @Column(name = "arabica_persentage")
    private double arabica_persentage;

    @Column(name = "sort")
    private int sort;

}
