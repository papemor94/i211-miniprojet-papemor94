package com.example.rest.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class BibliothequeDaoRepositoryJPA  implements IBibliothequeDaoRepositoryJPA{

public static EntityManager  entityManager;
    public BibliothequeDaoRepositoryJPA(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
         entityManager = entityManagerFactory.createEntityManager();

    }
    @Override
    public void init() {
        entityManager.getTransaction().begin();
        Auteur aut1 =   Auteur.builder()
                .firstname("a1")
                .lastname("f1")
                .build();

        Auteur aut2 = Auteur.builder()
                .firstname("a2")
                .lastname("f21")
                .build();

        entityManager.persist(aut1);
        entityManager.persist(aut2);


        entityManager.persist( Livre.builder().nom("Cryptographie").Categorie("Science").auteur(aut1).build());
        entityManager.persist( Livre.builder().nom("une vie de boy").Categorie("Roman").auteur(aut1).build());

        entityManager.getTransaction().commit();
    }
    @Override

    public void save(Livre livre) {
        entityManager.getTransaction().begin();
        entityManager.persist(livre);
        entityManager.getTransaction().commit();

    }
    @Override
    public void removeBook(int id) {
        entityManager.getTransaction().begin();
        Livre livre =entityManager.find(Livre.class ,id );

        if (livre == null) {
            throw new EntityNotFoundException("Can't find Livre for ID "
                    + id);
        }
        entityManager.remove( livre);
        entityManager.getTransaction().commit();

    }


    @Override
    public Livre findBookById(int uuid) {
        entityManager.getTransaction().begin();
        Livre livre =entityManager.find(Livre.class ,uuid );

       if (livre == null) {
            throw new EntityNotFoundException("Can't find Livre for ID "
                    + uuid);
        }
        entityManager.getTransaction().commit();
        System.out.println("trouvee" + livre.toString());
        return livre;
    }
    @Override
    public List<Livre> findBookByCategorie(String mc) {
        entityManager.getTransaction().begin();
        Query q =entityManager.createQuery("select s from Livre s where s.Categorie like :x");
        q.setParameter("x" , "%"+mc+"%");
        entityManager.getTransaction().commit();
        return q.getResultList();
    }
    @Override
    public List<Livre> findAllBook() {
        entityManager.getTransaction().begin();
        Query q =entityManager.createQuery("select s from Livre s");
        entityManager.getTransaction().commit();

        return q.getResultList();
    }


    @Override
    public void save(Auteur auteur) {
        entityManager.getTransaction().begin();
        entityManager.persist(auteur);
        entityManager.getTransaction().commit();
    }
    @Override
    public Auteur findAuthor(int id) {
        entityManager.getTransaction().begin();
        Auteur auteur =entityManager.find(Auteur.class ,id );

        if (auteur == null) {
            throw new EntityNotFoundException("Can't find Author for ID "
                    + id);
        }
        entityManager.getTransaction().commit();
        return auteur;
    }

    @Override
    public void removeAuteur(int id) {
        entityManager.getTransaction().begin();
        Auteur auteur =entityManager.find(Auteur.class ,id );

        if (auteur == null) {
                throw new EntityNotFoundException("Can't find Author for ID "
                    + id);
        }
        entityManager.remove( auteur);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<Auteur> findAllAuthor() {
        entityManager.getTransaction().begin();
        Query q =entityManager.createQuery("select s from Auteur s");
        entityManager.getTransaction().commit();

        return q.getResultList();
    }


    public static BibliothequeDaoRepositoryJPA getInstance() {
        if (serverInstance == null) {
            serverInstance = new BibliothequeDaoRepositoryJPA();
        }
        return serverInstance;
    }
    private static BibliothequeDaoRepositoryJPA serverInstance;

}

