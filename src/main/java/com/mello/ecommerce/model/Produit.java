package com.mello.ecommerce.model;

import com.mello.ecommerce.listener.GenererFactureListener;
import com.mello.ecommerce.listener.GenericListener;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EntityListeners({ GenericListener.class })
@Entity
@Table(name = "produit")
public class Produit {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String libelle;

    private String description;

    private BigDecimal prix;

    @Column(name = "date_creation", updatable = false)
    private LocalDateTime dateCreation;

    @Column(name = "date_dernier_mis_a_jour", insertable = false)
    private LocalDateTime dateDerniereMisAJour;


    @OneToMany (mappedBy = "produit")
    private List<LigneCommande> ligneCommandes;

    @ManyToMany
    @JoinTable(name = "produit_categorie",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Categorie> categories;

    @OneToOne(mappedBy = "produit")
    private Stock stock;



}