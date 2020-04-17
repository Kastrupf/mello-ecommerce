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
@Table(name = "commande")
public class Commande {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "date_commande")
    private LocalDateTime dateCommande;

    @Column(name = "date_cloture")
    private LocalDateTime dateCloture;

    @Column(name = "facture_id")
    private Integer factureId;

    private BigDecimal montant;

    @Enumerated(EnumType.STRING)
    private StatusCommande status;

    @Embedded
    private AdresseDestinataireCommande adresseDestinataire;

}
