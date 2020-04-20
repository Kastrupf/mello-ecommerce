package com.mello.ecommerce.model;

import com.mello.ecommerce.listener.GenererFactureListener;
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
@EntityListeners({ GenererFactureListener.class })
@Entity
@Table(name = "commande")
public class Commande {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne (fetch = FetchType.LAZY, optional = false) // o padrão é EAGER (ansioso), para forçar o INNER JOIN
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "date_commande")
    private LocalDateTime dateCommande;

    @Column(name = "date_dernier_mis_a_jour")
    private LocalDateTime dateDerniereMisAJour;

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

    public boolean isPayed() {
        return StatusCommande.PAYE.equals(status);
    }

//    @PrePersist
//    @PreUpdate
    public void calculerMontant() {
        if (ligneCommandes != null) {
            montant = ligneCommandes.stream().map(LigneCommande::getPrixProduit)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

    @PrePersist
    public void avantPersist() {
        dateCommande = LocalDateTime.now();
        calculerMontant();
    }

    @PreUpdate
    public void avantLeMisAJour() {
        dateDerniereMisAJour = LocalDateTime.now();
        calculerMontant();
    }
    @PostPersist
    public void aposPersistir() {
        System.out.println("Após persistir Pedido.");
    }

    @PostUpdate
    public void aposAtualizar() {
        System.out.println("Após atualizar Pedido.");
    }

    @PreRemove
    public void aoRemover() {
        System.out.println("Antes de remover Pedido.");
    }

    @PostRemove
    public void aposRemover() {
        System.out.println("Após remover Pedido.");
    }

    @PostLoad
    public void aoCarregar() {
        System.out.println("Após carregar o Pedido.");
    }
}