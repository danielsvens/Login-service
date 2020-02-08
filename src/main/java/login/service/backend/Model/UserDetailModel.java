package login.service.backend.Model;

import login.service.backend.Enum.Role;
import login.service.backend.Pojo.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_details")
public class UserDetailModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email", unique = true)
  @Email(message = "Invalid Email Address")
  private String email;

  @Column(name = "role")
  private Role role;

  @OneToOne(mappedBy = "userDetails")
  private UserModel user;

  UserDetail toPojo() {
    return UserDetail.builder()
            .firstName(firstName)
            .lastName(lastName)
            .email(email)
            .role(role)
            .build();
  }

  static UserDetailModel toModel(UserDetail userDetail) {
    return UserDetailModel.builder()
            .firstName(userDetail.getFirstName())
            .lastName(userDetail.getLastName())
            .email(userDetail.getEmail())
            .role(userDetail.getRole())
            .build();
  }
}
