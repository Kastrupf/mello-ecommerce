package com.mello.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@IdClass(LigneCommandeId.class)
@Entity
@Table(name = "ligne_commande")
public class LigneCommande {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "commande_id")
    private Integer commandeId;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "produit_id")
    private Integer produitId;

    @ManyToOne(optional = false) // é obrigatorio salvar a Commande junto
    @JoinColumn(name = "commande_id", insertable = false, updatable = false)
    private Commande commande;

    @ManyToOne(optional = false)// é obrigatorio salvar o Produto junto
    @JoinColumn(name = "produit_id", insertable = false, updatable = false)
    private Produit produit;

    @Column(name = "prix_produit")
    private BigDecimal prixProduit;

    private Integer quantite;

}
