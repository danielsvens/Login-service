package com.camera.backend.Service;

import com.camera.backend.Model.UserModel;
import com.camera.backend.Pojo.Login;
import com.camera.backend.Pojo.User;
import com.camera.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Optional<UserModel> findUser(long id) {
        return userRepository.findById(id);
    }

    public long saveNewUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(UserModel.toModel(user)).getId();
    }

    public boolean loginUser(Login loginRequest) {
        Optional<UserModel> userDetails = userRepository.findByUserName(loginRequest.getUserName());
        AtomicBoolean matchPassword = new AtomicBoolean(false);

        userDetails.ifPresent(fetchedUser -> matchPassword.set(
                bCryptPasswordEncoder.matches(loginRequest.getPassword(), fetchedUser.getPassword())));

        return matchPassword.get();
    }
}
