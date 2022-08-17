package com.wonder.blog.service;

import com.wonder.blog.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
