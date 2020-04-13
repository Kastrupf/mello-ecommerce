package com.mello.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "reglement_par_titre")
public class ReglementParTitre {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "commande_id")
    private Integer CommandeId;

    @Enumerated(EnumType.STRING)
    private StatusReglement status;

    @Column(name = "reference_compte")
    private String referenceCompte;
}
