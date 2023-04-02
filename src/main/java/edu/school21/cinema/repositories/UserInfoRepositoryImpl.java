package edu.school21.cinema.repositories;

import edu.school21.cinema.models.UserInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(UserInfo userInfo) {
        entityManager.persist(userInfo);
    }
}
