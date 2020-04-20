package com.mello.ecommerce.service;

import com.mello.ecommerce.model.Commande;

public class FactureService {

    public void generer(Commande commande) {
        System.out.println("Gerando facture para o pedido " + commande.getId() + ".");
    }
}
