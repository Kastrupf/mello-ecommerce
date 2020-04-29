package com.mello.ecommerce.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class LigneCommandeId implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "commande_id")
    private Integer commandeId;

    @EqualsAndHashCode.Include
    @Column(name = "produit_id")
    private Integer produitId;
}
