insert into produit (id, libelle, prix, description) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into produit (id, libelle, prix, description) values (3, 'Câmera GoPro Hero 7', 1400.0, 'Desempenho 2x melhor.');

insert into client (id, nom) values (1, 'PIRES DE MELLO');
insert into client (id, nom) values (2, 'MENDES KASTRUP');

insert into commande (id, client_id, date_commande, montant, status) values (1, 1, sysdate(), 100.0, 'ANNULE');

insert into ligne_commande (id, commande_id, produit_id, prix_produit, quantite) values (1, 1, 1, 5.0, 2);

insert into categorie (id, libelle) values (1, 'Eletrônicos');
