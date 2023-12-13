package org.example.services.user.impl;

import org.example.repositories.posts.PostEntity;
import org.example.repositories.users.UserEntity;
import org.example.repositories.users.UserRepository;
import org.example.services.posts.Post;
import org.example.services.posts.impl.SavePostAction;
import org.example.services.user.User;
import org.example.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();

        userRepository.findAll().iterator().forEachRemaining(userEntity -> {
            users.add(User.fromEntity(userEntity));
        });
        return users;
    }

    @Override
    public SaveUserAction saveUser(User user) {
        UserEntity userEntity = User.toEntity(user);
        userEntity = userRepository.save(userEntity);
        return new SaveUserAction(
                "User successfully saved, id: " + userEntity.getId(),
                User.fromEntity(userEntity),
                userEntity.getId());
    }

    @Override
    public Optional<User> getUserDetail(Long id) {
        return Optional.of(User.fromEntity(userRepository.findById(id).get()));
    }
}
