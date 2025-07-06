package com.bookaero.service;

import com.bookaero.entity.User;
import com.bookaero.exception.DuplicateFieldException;

public interface UserService {
    User userRegister(User user) throws DuplicateFieldException;
}
