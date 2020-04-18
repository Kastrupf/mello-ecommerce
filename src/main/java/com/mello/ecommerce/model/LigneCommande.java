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
@Entity
@Table(name = "ligne_commande")
public class LigneCommande {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false) // é obrigatorio salvar a Commande junto
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne(optional = false)// é obrigatorio salvar o Produto junto
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @Column(name = "prix_produit")
    private BigDecimal prixProduit;

    private Integer quantite;

}
