package com.mello.ecommerce.operationsWithEntityManager;


import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Produit;
import org.junit.Test;

import java.math.BigDecimal;

public class ContexteDePersistenceTest extends EntityManagerTest {

    @Test
    public void utiliserContextePersistence() {
        entityManager.getTransaction().begin();

        Produit produit = entityManager.find(Produit.class, 1);
        produit.setPrix(new BigDecimal(100.0));

        Produit produit2 = new Produit();
        produit2.setLibelle("Caneca para café");
        produit2.setPrix(new BigDecimal(10.0));
        produit2.setDescription("Boa caneca para café");
        entityManager.persist(produit2);

        Produit produit3 = new Produit();
        produit3.setLibelle("Caneca para chá");
        produit3.setPrix(new BigDecimal(10.0));
        produit3.setDescription("Boa caneca para chá");
        produit3 = entityManager.merge(produit3);

        entityManager.flush();

        produit3.setDescription("Alterar descrição");

        entityManager.getTransaction().commit();
    }
}
