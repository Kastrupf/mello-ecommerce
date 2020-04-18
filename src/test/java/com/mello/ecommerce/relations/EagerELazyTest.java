package com.mello.ecommerce.relations;


import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Commande;
import org.junit.Assert;
import org.junit.Test;

public class EagerELazyTest extends EntityManagerTest {

    @Test
    public void verfierComportment() {
        Commande commande = entityManager.find(Commande.class, 1);

//    commande.getLigneCommandes().isEmpty();
    }
}
