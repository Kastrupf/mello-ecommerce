package com.mello.ecommerce.AdvancedMapping;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class MapsIdTest extends EntityManagerTest {

    @Test
    public void insererReglement() {
        Commande commande = entityManager.find(Commande.class, 1);

        Facture facture = new Facture();
        facture.setCommande(commande);
        facture.setDateDelivrance(new Date());
        facture.setXml("<xml/>");

        entityManager.getTransaction().begin();
        entityManager.persist(facture);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Facture factureVerification = entityManager.find(Facture.class, facture.getId());
        Assert.assertNotNull(factureVerification);
        Assert.assertEquals(commande.getId(), factureVerification.getId());
    }

    @Test
    public void insererLigneCommande() {
        Client client = entityManager.find(Client.class, 1);
        Produit produit = entityManager.find(Produit.class, 1);

        Commande commande = new Commande();
        commande.setClient(client);
        commande.setDateCommande(LocalDateTime.now());
        commande.setStatus(StatusCommande.ANNULE);
        commande.setMontant(produit.getPrix());

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(new LigneCommandeId());
        ligneCommande.setCommande(commande);
        ligneCommande.setProduit(produit);
        ligneCommande.setPrixProduit(produit.getPrix());
        ligneCommande.setQuantite(1);

        entityManager.getTransaction().begin();
        entityManager.persist(commande);
        entityManager.persist(ligneCommande);
        entityManager.getTransaction().commit();

        entityManager.clear();

        LigneCommande ligneCommandeVerification = entityManager.find(
                LigneCommande.class, new LigneCommandeId(commande.getId(), produit.getId()));
        Assert.assertNotNull(ligneCommandeVerification);
    }
}
