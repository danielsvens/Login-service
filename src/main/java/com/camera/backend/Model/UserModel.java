package com.camera.backend.Model;

import com.camera.backend.Pojo.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id", referencedColumnName = "id")
    private UserDetailModel userDetails;

    public User toPojo() {
        return User.builder()
                .id(id)
                .userName(userName)
                .password(password)
                .userDetails(userDetails.toPojo())
                .build();
    }

    public static UserModel toModel(User user) {
        return UserModel.builder()
                .userName(user.getUserName())
                .password(user.getPassword())
                .userDetails(UserDetailModel.toModel(user.getUserDetails()))
                .build();
    }
}
