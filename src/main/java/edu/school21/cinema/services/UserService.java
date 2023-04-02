package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.models.UserInfo;
import edu.school21.cinema.repositories.UserRepository;
import edu.school21.cinema.utils.IpGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public int save(User user) {
        repository.save(user);
        return user.getId();
    }

    public User findById(int id) {
        return repository.findById(id);
    }

    @Transactional
    public User saveNewUserInfo(int id, HttpServletRequest request) {
        User user = repository.findById(id);
        UserInfo userInfo = new UserInfo();
        userInfo.setDateTime(new Date());
        userInfo.setIp(IpGetter.getClientIpAddress(request));
        List<UserInfo> list = user.getUserInfo();
        list.add(userInfo);
        userInfo.setUser(user);
        user.setUserInfo(list);
        return user;
    }
}
