package com.mello.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class AdresseDestinataireCommande {

    private String numero;

    private String voie;

    private String complement;

    private String cp;

    private String ville;

}
