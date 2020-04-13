package com.mello.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "reglement_par_carte")
public class ReglementParCarte {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "commande_id")
    private Integer CommandeId;

    private StatusReglement status;

    @Column(name = "numero_carte")
    private String numeroCarte;
}
