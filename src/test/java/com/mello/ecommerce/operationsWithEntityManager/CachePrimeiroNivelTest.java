package com.mello.ecommerce.operationsWithEntityManager;


import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Produit;
import org.junit.Test;

public class CachePrimeiroNivelTest extends EntityManagerTest {

    @Test
    public void verifierrCache() {
        Produit produit = entityManager.find(Produit.class, 1);
        System.out.println(produit.getLibelle());

        System.out.println("------------------------------");

//        entityManager.close();
//        entityManager = entityManagerFactory.createEntityManager();

        Produit produitRecupere = entityManager.find(Produit.class, produit.getId());
        System.out.println(produitRecupere.getLibelle());
    }
}
