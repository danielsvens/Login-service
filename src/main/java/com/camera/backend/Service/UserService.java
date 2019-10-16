package com.camera.backend.Service;

import com.camera.backend.Model.UserModel;
import com.camera.backend.Pojo.User;
import com.camera.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserModel> findUser(long id) {
        return userRepository.findById(id);
    }

    public long saveUser(User user) {
        return userRepository.save(UserModel.toModel(user)).getId();
    }
}
