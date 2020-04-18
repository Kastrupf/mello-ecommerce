package com.mello.ecommerce.relations;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Commande;
import org.junit.Assert;
import org.junit.Test;

public class RemoveEntitesDejaReferenceesTest extends EntityManagerTest {

    @Test
    public void removeEntitieRelacionee() {
        Commande commande = entityManager.find(Commande.class, 1);

        Assert.assertFalse(commande.getLigneCommandes().isEmpty());

        entityManager.getTransaction().begin();
        commande.getLigneCommandes().forEach(i -> entityManager.remove(i));
        entityManager.remove(commande);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Commande commandeVerification = entityManager.find(Commande.class, 1);
        Assert.assertNull(commandeVerification);
    }
}
