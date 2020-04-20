package com.mello.ecommerce.listener;


import com.mello.ecommerce.model.Commande;
import com.mello.ecommerce.service.FactureService;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class GenererFactureListener {

    private FactureService factureService = new FactureService();

    @PrePersist
    @PreUpdate
    public void generer(Commande commande) {
        if (commande.isPayed() && commande.getFacture() == null) {
            factureService.generer(commande);
        }
    }
}
