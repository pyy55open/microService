package com.csy.user.service.impl;

import com.csy.user.dataobject.User;
import com.csy.user.repository.UserRepository;
import com.csy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByOpenId(String openid) {
        return userRepository.findByOpenid(openid);
    }
}
