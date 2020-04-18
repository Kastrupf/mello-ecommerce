package com.mello.ecommerce.basiqueMapping;


import com.mello.ecommerce.EntityManagerTest;
import com.mello.ecommerce.model.AdresseDestinataireCommande;
import com.mello.ecommerce.model.Client;
import com.mello.ecommerce.model.Commande;
import com.mello.ecommerce.model.StatusCommande;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MappingEmbedableObjetTest extends EntityManagerTest {

    @Test
    public void analiserMappingObjectEmbedable() {
        Client client = entityManager.find(Client.class, 1);

        AdresseDestinataireCommande adresse = new AdresseDestinataireCommande();
        adresse.setNumero("123");
        adresse.setVoie("Rue Saint Louis");
        adresse.setComplement("apt. 30");
        adresse.setCp("33000");
        adresse.setVille("Bordeaux");

        Commande commande = new Commande();
//        commande.setId(1);  estamos usando IDENTITY
        commande.setDateCommande(LocalDateTime.now());
        commande.setStatus(StatusCommande.ENATTENTE);
        commande.setMontant(new BigDecimal(1000));
        commande.setAdresseDestinataire(adresse);
        commande.setClient(client);

        entityManager.getTransaction().begin();
        entityManager.persist(commande);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Commande commandeVerification = entityManager.find(Commande.class, commande.getId());
        Assert.assertNotNull(commandeVerification);
        Assert.assertNotNull(commandeVerification.getAdresseDestinataire());
        Assert.assertNotNull(commandeVerification.getAdresseDestinataire().getCp());
    }
}
