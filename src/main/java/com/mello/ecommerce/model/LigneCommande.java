package com.mello.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ligne_commande")
public class LigneCommande {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "commande_id")
    private Integer commandeId;

    @Column(name = "produit_id")
    private Integer produitId;

    @Column(name = "prix_produit")
    private BigDecimal prixProduit;

    private Integer quantite;

}
