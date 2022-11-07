package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Film;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FilmRepositoryImpl implements FilmRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Film> findAll() {
        return entityManager.createQuery("SELECT film FROM Film film", Film.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void save(Film film) {
        entityManager.persist(film);
    }
}
