package com.mello.ecommerce.relations;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelationOneToManyTest extends EntityManagerTest {

    @Test
    public void verifierRelationCommande() {
        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 1);
        Produit produit = entityManager.find(Produit.class, 1);

        Commande commande = new Commande();
        commande.setStatus(StatusCommande.ENATTENTE);
        commande.setDateCommande(LocalDateTime.now());
        commande.setMontant(BigDecimal.TEN);
        commande.setClient(client);

        entityManager.persist(commande);

        entityManager.flush();

        LigneCommande ligneCommande = new LigneCommande();
//        ligneCommande.setCommandeId(commande.getId());
//        ligneCommande.setProduitId(produit.getId());
        ligneCommande.setId(new LigneCommandeId(commande.getId(), produit.getId()));
        ligneCommande.setPrixProduit(produit.getPrix());
        ligneCommande.setQuantite(1);
        ligneCommande.setCommande(commande);
        ligneCommande.setProduit(produit);

        entityManager.persist(ligneCommande);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Commande commandeVerification = entityManager.find(
                Commande.class, commande.getId());
        Assert.assertFalse(commandeVerification.getLigneCommandes().isEmpty());
    }


    @Test
    public void verifierRelation() {
        Client client = entityManager.find(Client.class, 1);

        Commande commande = new Commande();
        commande.setStatus(StatusCommande.ENATTENTE);
        commande.setDateCommande(LocalDateTime.now());
        commande.setMontant(BigDecimal.TEN);

        commande.setClient(client);

        entityManager.getTransaction().begin();
        entityManager.persist(commande);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client clientVerification = entityManager.find(Client.class, client.getId());
        Assert.assertFalse(clientVerification.getCommandes().isEmpty());
    }

}
