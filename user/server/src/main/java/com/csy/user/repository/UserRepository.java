package com.csy.user.repository;

import com.csy.user.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByOpenid(String openid);
}
