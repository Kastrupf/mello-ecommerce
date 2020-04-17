package com.mello.ecommerce.relations;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AutoRelationTest extends EntityManagerTest {

    @Test
    public void verifierRelation() {
        Categorie categoriePere = new Categorie();
        categoriePere.setLibelle("Eletronicos");

        Categorie categorie = new Categorie();
        categorie.setLibelle("Celulares");
        categorie.setCategoriePere(categoriePere);

        entityManager.getTransaction().begin();
        entityManager.persist(categoriePere);
        entityManager.persist(categorie);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categorie categorieVerification = entityManager.find(Categorie.class, categorie.getId());
        Assert.assertNotNull(categorieVerification.getCategoriePere());

        Categorie categoriePereVerification = entityManager.find(Categorie.class, categoriePere.getId());
        Assert.assertFalse(categoriePereVerification.getCategories().isEmpty());
    }
}
