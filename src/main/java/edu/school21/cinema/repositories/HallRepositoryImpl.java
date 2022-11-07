package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class HallRepositoryImpl implements HallRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Hall> findAll() {
        return entityManager.createQuery("SELECT hall FROM Hall hall", Hall.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void save(Hall hall) {
        entityManager.persist(hall);
    }
}
