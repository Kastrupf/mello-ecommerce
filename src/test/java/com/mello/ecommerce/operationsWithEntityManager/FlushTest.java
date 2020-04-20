package com.mello.ecommerce.operationsWithEntityManager;

import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Commande;
import com.mello.ecommerce.model.StatusCommande;
import org.junit.Test;

public class FlushTest extends EntityManagerTest {

    @Test(expected = Exception.class)
    public void apppelerFlush() {
        try {
            entityManager.getTransaction().begin();

            Commande commande = entityManager.find(Commande.class, 1);
            commande.setStatus(StatusCommande.PAYE);

            entityManager.flush();

            if (commande.getReglement() == null) {
                throw new RuntimeException("Pedido ainda não foi pago.");
            }

//            Uma consulta obriga o JPA a sincronizar o que ele tem na memória (sem usar o flush explicitamente).
//            Commande commandeReglee = entityManager
//                    .createQuery("select c from Commande c where c.id = 1", Commande.class)
//                    .getSingleResult();
//            Assert.assertEquals(commande.getStatus(), commandeReglee.getStatus());

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
