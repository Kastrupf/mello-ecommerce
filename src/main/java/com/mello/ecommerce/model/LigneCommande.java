package com.mello.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class LigneCommande {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private Integer commandeId;

    private Integer produitId;

    private BigDecimal prixProduit;

    private Integer quantite;

}
