package com.mello.ecommerce.startingWithJpa;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Produit;
import org.junit.*;


public class RegistreConsultingTest extends EntityManagerTest {

    @Test
    public void chercherParIdentifiant() {
        Produit produit = entityManager.find(Produit.class, 1);
//        Produit produit = entityManager.getReference(Produit.class, 1);

        Assert.assertNotNull(produit);
        Assert.assertEquals("Kindle", produit.getLibelle());
    }

    @Test
    public void mettreAJourLaAReference() {
        Produit produit = entityManager.find(Produit.class, 1);
        produit.setLibelle("Microfone Samson");

        entityManager.refresh(produit);

        Assert.assertEquals("Kindle", produit.getLibelle());
    }

}