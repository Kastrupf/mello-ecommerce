package com.mello.ecommerce.operationsWithEntityManager;


import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.Categorie;
import org.junit.Test;

public class EstadosECicloDeVidaTest extends EntityManagerTest {

    @Test
    public void analisarEstados() {
        Categorie categorieNouvelle = new Categorie();

        Categorie categorieManageeMerge = entityManager.merge(categorieNouvelle);

        Categorie categorieManagee = entityManager.find(Categorie.class, 1);

        entityManager.remove(categorieManagee);
        entityManager.persist(categorieManagee);

        entityManager.detach(categorieManagee);
    }

}
