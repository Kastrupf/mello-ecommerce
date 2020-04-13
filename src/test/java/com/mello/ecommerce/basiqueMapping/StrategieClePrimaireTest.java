package com.mello.ecommerce.basiqueMapping;


import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Categorie;
import org.junit.Assert;
import org.junit.Test;

public class StrategieClePrimaireTest extends EntityManagerTest {

    @Test
    public void testerStrategieAuto() {
        Categorie categorie = new Categorie();
        categorie.setLibelle("Eletrônicos");

        entityManager.getTransaction().begin();
        entityManager.persist(categorie);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categorie categorieVerification = entityManager.find(Categorie.class, categorie.getId());
        Assert.assertNotNull(categorieVerification);
    }
}
