package com.fourtomik.legiz.user.service;

import com.fourtomik.legiz.user.domain.model.User;
import com.fourtomik.legiz.user.domain.repository.UserRepository;
import com.fourtomik.legiz.user.domain.service.UserService;
import com.fourtomik.legiz.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User updateUser(Long userId, User userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->new ResourceNotFoundException("User","Id",userId));
        return userRepository.save(
                user.setName(userRequest.getName())
                        .setSurname(userRequest.getSurname())
                        .setEmail(userRequest.getEmail())
                        .setPassword(userRequest.getPassword())
                        .setDate_Birthday(userRequest.getDate_Birthday())
                        .setDNI(userRequest.getDNI())
        );
    }
}
