package com.mello.ecommerce.startingwithjpa;

import com.mello.ecommerce.EntityManagerTest;
import org.junit.Test;

public class OperationsAvecTransactionTest extends EntityManagerTest {

    @Test
    public void ouvrirEtFermerLaTransaction() {
//        Produit produit = new Produit(); // Somente para o método não mostrar erros.

        entityManager.getTransaction().begin();

//        entityManager.persist(produit);
//        entityManager.merge(produit);
//        entityManager.remove(produit);

        entityManager.getTransaction().commit();
    }
}