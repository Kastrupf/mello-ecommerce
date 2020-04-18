package com.mello.ecommerce.relations;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Categorie;
import com.mello.ecommerce.model.Produit;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class RelationsManyToManyTest extends EntityManagerTest {

    @Test
    public void verifierRelation() {
        Produit produit = entityManager.find(Produit.class, 1);
        Categorie categorie = entityManager.find(Categorie.class, 1);

        entityManager.getTransaction().begin();
//        categorie.setProduits(Arrays.asList(produit)); // nao da certo porque produto nao é o owner da relaçao.
        produit.setCategories(Arrays.asList(categorie));
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categorie categoriaVerification = entityManager.find(Categorie.class, categorie.getId());
        Assert.assertFalse(categoriaVerification.getProduits().isEmpty());
    }
}
