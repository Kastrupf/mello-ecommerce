package com.mello.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categorie {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private String libelle;

    private Integer CategoriePereId;

}
