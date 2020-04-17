package com.mello.ecommerce.basiqueMapping;


import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Client;
import com.mello.ecommerce.model.SexeClient;
import org.junit.Assert;
import org.junit.Test;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

    @Test
    public void testerEnum() {
        Client client = new Client();
//        client.setId(5); Estamos usando IDENTITY
        client.setNom("José Mineiro");
        client.setSexe(SexeClient.MASCUILIN);

        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client clientVerification = entityManager.find(Client.class, client.getId());
        Assert.assertNotNull(clientVerification);
    }
}
