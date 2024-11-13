package org.tp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.tp.data.Book;

public class FilmDaO implements CRUDRepository<Film> {
    private final EntityManagerFactory emf;

    public FilmDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @Override
    public void create(Film film) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(film);
        em.getTransaction().commit();
        em.close();
    }
    @Override
    public Film findById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Film.class,id);
    }

    @Override
    public List<Film> findAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Book> query = em.createQuery("SELECT a From Film a",Film.class);
        List<Film> films = query.getResultList();
        return films;
    }

    @Override
    public void update(Film film) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(film);
        em.getTransaction.commit();
        em.close();
    }

    @Override
    public void delete(Film film) {
        EntityManager em = emf.createEntityManager();
        // TO DO
        em.close();
    }

    public List<Film> findFilmsbyActorID(Long ActorID) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Film> query = em.createQuery("SELECT a From Film f JOIN f.Actor a WHERE f.ActorID = :Actor",Film.class);
        List<Film> films = query.getResultList();
        em.close();
        return films;
    }

    public List<Film> findFilmByCategoryName(String categoryName) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Book> query = em.createQuery("SELECT c.filmID From Categorie c WHERE category = :categoryName;",Film.class);
        List<Film> films = query.getResultList();
        em.close();
        return films;
    }
}
