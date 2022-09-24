package com.fourtomik.legiz.user.domain.service;

import com.fourtomik.legiz.user.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);
    User updateUser(Long userId, User userRequest);
}
