import login.service.backend.Pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
public class unitTest {

    @Test
    public void pelle() {
        User user1 = new User(1L, "1", "p", null);
        User user2 = new User(2L, "2", "f", null);

        List<User> users = Arrays.asList(user1, user2);

        List<String> newUsers = users.stream()
            .map(u -> u.getUserName() + " " + u.getPassword())
            .collect(Collectors.toList());

        log.info("" + newUsers);
    }
}
