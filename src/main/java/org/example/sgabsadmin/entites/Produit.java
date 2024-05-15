package org.example.sgabsadmin.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String titre;
    private  String description;
    private  int duree;
    private  float tarif;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;






}
