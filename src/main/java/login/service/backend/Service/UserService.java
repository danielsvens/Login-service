package login.service.backend.Service;

import login.service.backend.Model.UserModel;
import login.service.backend.Pojo.Login;
import login.service.backend.Pojo.User;
import login.service.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    Optional<UserModel> user = userRepository.findByUserName(loginRequest.getUserName());

    return user.filter(userModel ->
            bCryptPasswordEncoder.matches(loginRequest.getPassword(), userModel.getPassword())).isPresent();
  }
}
