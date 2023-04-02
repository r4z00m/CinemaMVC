package edu.school21.cinema.services;

import edu.school21.cinema.models.UserInfo;
import edu.school21.cinema.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserInfoService {

    private final UserInfoRepository repository;

    @Autowired
    public UserInfoService(UserInfoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void save(UserInfo userInfo) {
        repository.save(userInfo);
    }
}
