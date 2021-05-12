package hr.java.matijevic.vaxapp.user;

import hr.java.matijevic.vaxapp.authority.Authority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceUser implements ServiceUser {

    private final UserRepository userRepository;

    public UserServiceUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::mapUserToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findOneByUsername(String username) {
        return userRepository.findOneByUsername(username).map(this::mapUserToDTO);
    }


    private UserDTO mapUserToDTO(final User user){
        return new UserDTO(user.getId(),user.getUsername(), user.getFirst_name(), user.getLast_name(),
                user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));
    }
}
