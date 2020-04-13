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
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "facture")
public class Facture {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "commande_id")
    private Integer commandeId;

    private String xml;

    @Column(name = "date_delivrance")
    private Date dateDelivrance;

}