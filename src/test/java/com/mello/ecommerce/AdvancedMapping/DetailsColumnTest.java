package com.mello.ecommerce.AdvancedMapping;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Produit;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DetailsColumnTest extends EntityManagerTest {

    @Test
    public void interdireInsertionCollumnMisAJour() {
        Produit produit = new Produit();
        produit.setLibelle("Teclado para smartphone");
        produit.setDescription("O mais confortável");
        produit.setPrix(BigDecimal.ONE);
        produit.setDateCreation(LocalDateTime.now());
        produit.setDateDerniereMisAJour(LocalDateTime.now());

        entityManager.getTransaction().begin();
        entityManager.persist(produit);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produit produitVerification = entityManager.find(Produit.class, produit.getId());
        Assert.assertNotNull(produitVerification.getDateCreation());
        Assert.assertNull(produitVerification.getDateDerniereMisAJour());
    }

    @Test
    public void nterdireInsertionCollumnCreation() {
        entityManager.getTransaction().begin();

        Produit produit = entityManager.find(Produit.class, 1);
        produit.setPrix(BigDecimal.TEN);
        produit.setDateCreation(LocalDateTime.now());
        produit.setDateDerniereMisAJour(LocalDateTime.now());

        entityManager.getTransaction().commit();

        entityManager.clear();

        Produit produitVerification = entityManager.find(Produit.class, produit.getId());
        Assert.assertNotEquals(produit.getDateCreation().truncatedTo(ChronoUnit.SECONDS),
                produitVerification.getDateCreation().truncatedTo(ChronoUnit.SECONDS));
        Assert.assertEquals(produit.getDateDerniereMisAJour().truncatedTo(ChronoUnit.SECONDS),
                produitVerification.getDateDerniereMisAJour().truncatedTo(ChronoUnit.SECONDS));
    }
}
