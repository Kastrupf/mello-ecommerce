package com.mello.ecommerce.startingwithjpa;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Produit;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperationsAvecTransactionTest extends EntityManagerTest {

    /*@Test
    public void empecherOperationsAvecLaBasedeDonnees() {
        Produit produit = entityManager.find(Produit.class, 1);
        entityManager.detach(produit);

        entityManager.getTransaction().begin();
        produit.setLibelle("Kindle Paperwhite 2ª Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produit produitVerification = entityManager.find(Produit.class, produit.getId());
        Assert.assertEquals("Kindle", produitVerification.getLibelle());
    }*/

    @Test
    public void insertionDUnProduitAvecMerge() {
        Produit produit = new Produit();

//        produit.setId(4);
        produit.setLibelle("Microfone Rode Videmic");
        produit.setDescription("A melhor qualidade de som.");
        produit.setPrix(new BigDecimal(1000));

        entityManager.getTransaction().begin();
        Produit produitSave =entityManager.merge(produit);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produit produitVerification = entityManager.find(Produit.class, produitSave.getId());
        Assert.assertNotNull(produitVerification);
    }

    @Test
    public void miseAJourObjet() {
        Produit produit = entityManager.find(Produit.class, 1);

        entityManager.getTransaction().begin();
        produit.setLibelle("Kindle Paperwhite 2ª Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produit produitVerification = entityManager.find(Produit.class, produit.getId());
        Assert.assertEquals("Kindle Paperwhite 2ª Geração", produitVerification.getLibelle());
    }

    @Test
    public void miseAJourProduit() {
        Produit produit = new Produit();

        produit.setId(1);
        produit.setLibelle("Kindle Paperwhite");
        produit.setDescription("Conheça o novo Kindle.");
        produit.setPrix(new BigDecimal(599));

        entityManager.getTransaction().begin();
        entityManager.merge(produit);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produit produitVerification = entityManager.find(Produit.class, produit.getId());
        Assert.assertNotNull(produitVerification);
        Assert.assertEquals("Kindle Paperwhite", produitVerification.getLibelle());
    }

    @Test
    public void remotionDUnProduit() {
        Produit produit = entityManager.find(Produit.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produit);
        entityManager.getTransaction().commit();

//        entityManager.clear(); Não é necessário na asserção para operação de remoção.

        Produit produitVerification = entityManager.find(Produit.class, 3);
        Assert.assertNull(produitVerification);
    }

    @Test
    public void insertionDuPremmierProduit() {
        Produit produit = new Produit();

 //       produit.setId(2);
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