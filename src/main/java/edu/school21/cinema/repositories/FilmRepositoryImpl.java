package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Film;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class FilmRepositoryImpl implements FilmRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Film> findAll() {
        return entityManager.createQuery("FROM Film", Film.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void save(Film film) {
        entityManager.persist(film);
    }

    @Override
    public Film findById(int id) {
        return entityManager.find(Film.class, id);
    }
}
