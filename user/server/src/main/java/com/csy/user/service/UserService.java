package com.csy.user.service;

import com.csy.user.dataobject.User;

public interface UserService {

    User findByOpenId(String openid);
}
