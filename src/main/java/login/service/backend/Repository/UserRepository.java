package login.service.backend.Repository;

import login.service.backend.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>,
        JpaSpecificationExecutor<UserModel> {

  Optional<UserModel> findById(long id);

  Optional<UserModel> findByUserName(String username);
}
