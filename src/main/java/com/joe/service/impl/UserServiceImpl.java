package com.joe.service.impl;

import com.joe.entity.User;
import com.joe.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:joe
 * @date:2019/5/20 19:44
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Map<String, User> USER_DB = new ConcurrentHashMap<>();

    static {
        User user = new User();
        user.setId("2019");
        user.setName("joe");
        user.setAge(18);
        USER_DB.put("joe", user);

    }

    @Override
    public boolean checkUser(String loginName, String password) {
        if (loginName == null || loginName.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }
        User user = USER_DB.get(loginName);
        if (user == null) {
            return false;
        }
        return password.equals(user.getName() + "123");

    }

    @Override
    public User getUserByLoginName(String loginName) {
        return USER_DB.get(loginName);
    }
}
