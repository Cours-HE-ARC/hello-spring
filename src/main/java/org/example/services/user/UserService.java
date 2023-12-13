package org.example.services.user;

import org.example.services.posts.impl.SavePostAction;
import org.example.services.user.impl.SaveUserAction;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    SaveUserAction saveUser(User user);

    Optional<User> getUserDetail(Long aLong);
}
