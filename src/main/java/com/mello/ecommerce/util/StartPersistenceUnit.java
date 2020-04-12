package com.mello.ecommerce.util;

import com.mello.ecommerce.model.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StartPersistenceUnit {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Produit produit = entityManager.find(Produit.class, 1);
        System.out.println(produit.getLibelle());

        entityManager.close();
        entityManagerFactory.close();
    }
}