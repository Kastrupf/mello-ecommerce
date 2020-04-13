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
public class ReglementParCarte {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private Integer CommandeId;

    private StatusReglement status;

    private String numeroCarte;
}
