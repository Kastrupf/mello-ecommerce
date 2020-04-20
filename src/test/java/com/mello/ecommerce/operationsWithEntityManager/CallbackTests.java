package com.mello.ecommerce.operationsWithEntityManager;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Client;
import com.mello.ecommerce.model.Commande;
import com.mello.ecommerce.model.StatusCommande;
import org.junit.Assert;
import org.junit.Test;

public class CallbackTests extends EntityManagerTest {

    @Test
    public void activerCallbacks () {
        Client client = entityManager.find(Client.class, 1);

        Commande commande = new Commande();

        commande.setClient(client);
        commande.setStatus(StatusCommande.ANNULE);

        entityManager.getTransaction().begin();

        entityManager.persist(commande);
        entityManager.flush();

        commande.setStatus(StatusCommande.PAYE);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Commande commandeVerfication = entityManager.find(Commande.class, commande.getId());
        Assert.assertNotNull(commandeVerfication.getDateCommande());
        Assert.assertNotNull(commandeVerfication.getDateDerniereMisAJour());





    }
}
