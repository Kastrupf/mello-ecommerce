package com.mello.ecommerce.startingwithjpa;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Produit;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperationsAvecTransactionTest extends EntityManagerTest {

    @Test
    public void insertionDuPremmierProduit() {
        Produit produit = new Produit();

        produit.setId(2);
        produit.setLibelle("Câmera Canon");
        produit.setDescription("A melhor definição para suas fotos.");
        produit.setPrix(new BigDecimal(5000));

        entityManager.getTransaction().begin();
        entityManager.persist(produit);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produit produitVerification = entityManager.find(Produit.class, produit.getId());
        Assert.assertNotNull(produitVerification);
    }

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