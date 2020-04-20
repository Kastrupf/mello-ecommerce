package com.mello.ecommerce.operationsWithEntityManager;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Commande;
import com.mello.ecommerce.model.StatusCommande;
import org.junit.Test;

public class ManagingTransactionsTest extends EntityManagerTest {

    @Test(expected = Exception.class)
    public void ouvrirFermerAnnulerTransactions() {
        try {
            entityManager.getTransaction().begin();
            metodoDeNegocio();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    private void metodoDeNegocio() {
        Commande commande = entityManager.find(Commande.class, 1);
        commande.setStatus(StatusCommande.PAYE);

        if (commande.getReglement() == null) {
            throw new RuntimeException("Pedido ainda não foi pago.");
        }
    }
}
