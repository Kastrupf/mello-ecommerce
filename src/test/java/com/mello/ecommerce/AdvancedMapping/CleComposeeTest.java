package com.mello.ecommerce.AdvancedMapping;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class CleComposeeTest extends EntityManagerTest {

    @Test
    public void enregistrerLigneCommande() {
        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 1);
        Produit produit = entityManager.find(Produit.class, 1);

        Commande commande = new Commande();
        commande.setClient(client);
        commande.setDateCommande(LocalDateTime.now());
        commande.setStatus(StatusCommande.PAYE);
        commande.setMontant(produit.getPrix());

        entityManager.persist(commande);

        entityManager.flush(); // pega o que esta na memoria e sincroniza.

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setCommandeId(commande.getId());
        ligneCommande.setProduitId(produit.getId());
        ligneCommande.setCommande(commande);
        ligneCommande.setProduit(produit);
        ligneCommande.setPrixProduit(produit.getPrix());
        ligneCommande.setQuantite(1);

        entityManager.persist(ligneCommande);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Commande commandeVerification = entityManager.find(Commande.class, commande.getId());
        Assert.assertNotNull(commandeVerification);
        Assert.assertFalse(commandeVerification.getLigneCommandes().isEmpty());
    }

    @Test
    public void chercherLigneCommande() {
        LigneCommande ligneCommande = entityManager.find(
                LigneCommande.class, new LigneCommandeId(1, 1));

        Assert.assertNotNull(ligneCommande);
    }
}

