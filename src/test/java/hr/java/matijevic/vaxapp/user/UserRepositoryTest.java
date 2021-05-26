package hr.java.matijevic.vaxapp.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findOneByUsername() {
        Optional<User> user = userRepository.findOneByUsername("user");
        User us = user.get();
        Assertions.assertEquals(us.getUsername(), "user");

    }

    @Test
    void findAll(){
        List<User> user = userRepository.findAll();
        Assertions.assertEquals(user.size(), 3);

    }
}