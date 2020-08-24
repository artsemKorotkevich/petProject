package by.innowise.taskService;

import by.innowise.taskService.config.FlywayMigrationConfig;
import by.innowise.taskService.entities.User;
import by.innowise.taskService.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@Import(FlywayMigrationConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void saveUser() {
        User user = new User();
        user.setName("artem");
        user.setEmail("test1@gmail.com");
        userRepository.save(user);
        Assert.assertEquals(user, userRepository.findUserById(2));
    }

    @Test
    @Transactional
    public void saveListUser() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setName("artem");
        user.setEmail("test1@gmail.com");
        userList.add(user);
        User user1 = new User();
        user1.setName("ivan");
        user1.setEmail("test2@gmail.com");
        userList.add(user1);
        User user2 = new User();
        user2.setName("gena");
        user2.setEmail("test3@gmail.com");
        userList.add(user2);
        userRepository.saveAll(userList);
        List<User> users = userRepository.findAll();
        Assert.assertEquals(4,users.size());
    }
    @Test
    public void updateUser(){
        User userById = userRepository.findUserById(1);
        userById.setName("test11");
        userRepository.save(userById);
        Assert.assertEquals("test11",userRepository.findUserById(1).getName());
    }

    @Test
    public void deleteUser(){
        User user = new User();
        user.setName("artem");
        user.setEmail("test1@gmail.com");
        Assert.assertTrue(userRepository.findById(2l).isEmpty());
        userRepository.save(user);
        Assert.assertFalse(userRepository.findById(2l).isEmpty());
        userRepository.deleteById(2l);
        Assert.assertTrue(userRepository.findById(2l).isEmpty());
    }
}