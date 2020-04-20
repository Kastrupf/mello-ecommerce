package com.mello.ecommerce.operationsWithEntityManager;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Client;
import com.mello.ecommerce.model.Commande;
import com.mello.ecommerce.model.Produit;
import com.mello.ecommerce.model.StatusCommande;
import org.junit.Assert;
import org.junit.Test;

public class ListenersTest extends EntityManagerTest {

    @Test
    public void chargerEntity() {
        Produit produit = entityManager.find(Produit.class, 1);
        Commande commande = entityManager.find(Commande.class, 1);
    }

    @Test
    public void acionarCallbacks() {
        Client client = entityManager.find(Client.class, 1);

        Commande commande = new Commande();

        commande.setClient(client);
        commande.setStatus(StatusCommande.ENATTENTE);

        entityManager.getTransaction().begin();

        entityManager.persist(commande);
        entityManager.flush();

        commande.setStatus(StatusCommande.PAYE);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Commande commandeVerification = entityManager.find(Commande.class, commande.getId());
        Assert.assertNotNull(commandeVerification.getDateCommande());
        Assert.assertNotNull(commandeVerification.getDateDerniereMisAJour());
    }
}
