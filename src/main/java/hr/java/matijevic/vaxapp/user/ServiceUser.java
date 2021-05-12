package hr.java.matijevic.vaxapp.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ServiceUser {

    List<UserDTO> findAll();
    Optional<UserDTO> findOneByUsername(String username);
}
