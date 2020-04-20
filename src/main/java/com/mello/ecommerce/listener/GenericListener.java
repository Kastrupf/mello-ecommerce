package com.mello.ecommerce.listener;

import javax.persistence.PostLoad;

public class GenericListener {

    @PostLoad
    public void logChargement(Object obj) {
        System.out.println("Entity " + obj.getClass().getSimpleName() + " a été chargée.");
    }
}
