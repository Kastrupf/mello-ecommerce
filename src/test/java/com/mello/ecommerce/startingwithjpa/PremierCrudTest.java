package com.mello.ecommerce.startingwithjpa;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Client;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PremierCrudTest extends EntityManagerTest {

    @Test
    public void insererRegistre() {
        Client client = new Client();

//       client.setId(3);
        client.setNom("DE ALMEIDA ORLANDO");

        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client clientVerification = entityManager.find(Client.class, client.getId());
        Assert.assertNotNull(clientVerification);
    }

    @Test
    public void chercherParIdentifiant() {
        Client client = new Client();

//        client.setId(4);
        client.setNom("LOYOLA");

        entityManager.find(Client.class, 1);

        Assert.assertNotNull(client);
        Assert.assertEquals("LOYOLA", client.getNom());
    }

    @Test
    public void mettreAJourRegistre() {
        Client client = new Client();

        client.setId(1);
        client.setNom("MENDES");

        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client clientVerification = entityManager.find(Client.class, client.getId());
        Assert.assertNotNull(clientVerification);
        Assert.assertEquals("MENDES", clientVerification.getNom());
    }

    @Test
    public void removeRegistre() {
        Client client = entityManager.find(Client.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(client);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client clientVerification = entityManager.find(Client.class, client.getId());
        Assert.assertNull(clientVerification);
    }
}
