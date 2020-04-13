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
@Table(name = "commande")
public class Commande {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "date_commande")
    private LocalDateTime dateCommande;

    @Column(name = "date_cloture")
    private LocalDateTime dateCloture;

    @Column(name = "facture_id")
    private Integer factureId;

    private BigDecimal montant;

    private StatusCommande status;

}
