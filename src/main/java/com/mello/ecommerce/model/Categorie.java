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
@Table(name = "categorie")
public class Categorie {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private String libelle;

    @Column(name = "categorie_pere_id")
    private Integer CategoriePereId;

}
