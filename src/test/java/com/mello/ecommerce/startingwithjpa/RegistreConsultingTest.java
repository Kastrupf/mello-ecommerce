package com.mello.ecommerce.startingwithjpa;

import com.mello.ecommerce.model.Produit;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegistreConsultingTest {

    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeClass
    public static void setUpBeforeClass() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        entityManagerFactory.close();
    }

    @Before
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown() {
        entityManager.close();
    }

    @Test
    public void chercherParIdentifiant() {
        Produit produit = entityManager.find(Produit.class, 1);
//        Produit produit = entityManager.getReference(Produit.class, 1);

        Assert.assertNotNull(produit);
        Assert.assertEquals("Kindle", produit.getLibelle());
    }

    @Test
    public void mettreAJourLaAReference() {
        Produit produit = entityManager.find(Produit.class, 1);
        produit.setLibelle("Microfone Samson");

        entityManager.refresh(produit);

        Assert.assertEquals("Kindle", produit.getLibelle());
    }

}