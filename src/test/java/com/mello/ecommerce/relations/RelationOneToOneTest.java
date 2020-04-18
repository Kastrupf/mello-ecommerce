package com.mello.ecommerce.relations;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class RelationOneToOneTest extends EntityManagerTest {

    @Test
    public void VerifierRelationFactureCommande() {
        Commande commande = entityManager.find (Commande.class, 1);

        Facture facture = new Facture();
        facture.setDateDelivrance(new Date());
        facture.setXml("TESTE");
        facture.setCommande(commande);

        entityManager.getTransaction().begin();
        entityManager.persist(facture);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Commande commandeVerification = entityManager.find(Commande.class, commande.getId());
        Assert.assertNotNull(commandeVerification.getFacture());
    }

    @Test
    public void VerifierRelationCommandeReglementParCarte() {
        Commande commande = entityManager.find (Commande.class, 1);

        ReglementParCarte reglementParCarte = new ReglementParCarte();
        reglementParCarte.setNumeroCarte("5555");
        reglementParCarte.setStatus(StatusReglement.RECU);
        reglementParCarte.setCommande(commande);

        entityManager.getTransaction().begin();
        entityManager.persist(reglementParCarte);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Commande commandeVerification = entityManager.find(Commande.class, commande.getId());
        Assert.assertNotNull(commandeVerification.getReglement());
    }
}