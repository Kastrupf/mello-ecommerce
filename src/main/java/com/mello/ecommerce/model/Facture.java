package com.mello.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "facture")
public class Facture {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false) // sempre que eu salvar uma nota fiscal, tenho que ter um pedido
    @JoinColumn(name = "commande_id")
//    @JoinTable(name = "commande_facture",
//            joinColumns = @JoinColumn(name = "facture_id", unique = true),
//            inverseJoinColumns = @JoinColumn(name = "commande_id", unique = true))
    private Commande commande;

    private String xml;

    @Column(name = "date_delivrance")
    private Date dateDelivrance;

}