package com.example.rest.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class BibliothequeDaoRepositoryJPA  implements IBibliothequeDaoRepositoryJPA{

public static EntityManager  entityManager;
    public BibliothequeDaoRepositoryJPA() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
         entityManager = entityManagerFactory.createEntityManager();

    }
    @Override

    public void save(Livre livre) {
        entityManager.getTransaction().begin();
        entityManager.persist(livre);
        entityManager.getTransaction().commit();

    }

    @Override
    public void save(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();

    }

    @Override
    public void save(Auteur auteur) {
        entityManager.getTransaction().begin();
        entityManager.persist(auteur);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<Livre> findAll() {
        entityManager.getTransaction().begin();
        Query q =entityManager.createQuery("select s from Livre s");
        entityManager.getTransaction().commit();

        return q.getResultList();
    }

    @Override
    public List<Book> getAllBook() {
        entityManager.getTransaction().begin();
        Query q =entityManager.createQuery("select s from Book s");
        entityManager.getTransaction().commit();

        return q.getResultList();
    }

    @Override
    public List<Livre> findByCategorie(String mc) {
        entityManager.getTransaction().begin();
        Query q =entityManager.createQuery("select s from Livre s where s.Categorie like :x");
        q.setParameter("x" , "%"+mc+"%");
        entityManager.getTransaction().commit();
        return q.getResultList();
    }

    @Override
    public void update(Livre livre) {

    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Livre findById(UUID uuid) {
        entityManager.getTransaction().begin();
        entityManager.find(Livre.class ,uuid );
        entityManager.getTransaction().commit();
        return null;
    }
}

