package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SessionRepositoryImpl implements SessionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Session> findAll() {
        return entityManager.createQuery("SELECT session FROM Session session", Session.class)
                .getResultList();
    }
}
