package com.mello.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne (fetch = FetchType.LAZY) // o padrão é EAGER (ansioso)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "date_commande")
    private LocalDateTime dateCommande;

    @Column(name = "date_cloture")
    private LocalDateTime dateCloture;

    @OneToOne(mappedBy = "commande", fetch = FetchType.EAGER) // o padrão é LAZY (preguiçoso)
    private Facture facture;

    private BigDecimal montant;

    @OneToMany (mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;

    @Enumerated(EnumType.STRING)
    private StatusCommande status;

    @OneToOne(mappedBy = "commande")
    private ReglementParCarte reglement;

    @Embedded
    private AdresseDestinataireCommande adresseDestinataire;

}
