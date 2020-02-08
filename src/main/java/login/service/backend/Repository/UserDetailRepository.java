package login.service.backend.Repository;

import login.service.backend.Model.UserDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailModel, Long> {
}
