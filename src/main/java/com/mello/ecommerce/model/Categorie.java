package com.mello.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "categorie")
public class Categorie {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String libelle;

    @ManyToOne
    @JoinColumn(name = "categorie_pere_id")
    private Categorie categoriePere;

    @OneToMany (mappedBy = "categoriePere")
    private List<Categorie> categories;

}
