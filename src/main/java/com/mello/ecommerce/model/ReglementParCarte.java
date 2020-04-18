package com.mello.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "reglement_par_carte")
public class ReglementParCarte {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @Enumerated(EnumType.STRING)
    private StatusReglement status;

    @Column(name = "numero_carte")
    private String numeroCarte;
}
