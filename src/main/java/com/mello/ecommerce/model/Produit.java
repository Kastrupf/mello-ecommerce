package com.mello.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "produit")
public class Produit {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private String libelle;

    private String description;

    private BigDecimal prix;


}