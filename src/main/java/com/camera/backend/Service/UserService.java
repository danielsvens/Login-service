package com.camera.backend.Service;

import com.camera.backend.Model.UserModel;
import com.camera.backend.Pojo.User;
import com.camera.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserModel> findUser(long id) {
        return userRepository.findById(id);
    }

    /*
     * .springframework.orm.jpa.JpaSystemException: attempted to assign id from null one-to-one property
     * [com.camera.backend.Model.UserDetailModel.user];
     * nested exception is org.hibernate.id.IdentifierGenerationException:
     * attempted to assign id from null one-to-one property
     * [com.camera.backend.Model.UserDetailModel.user]] with root cause
     */
    public long saveUser(User user) {
        return userRepository.save(UserModel.toModel(user)).toPojo().getId();
    }
}

