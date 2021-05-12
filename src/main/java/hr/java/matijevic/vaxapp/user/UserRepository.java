package hr.java.matijevic.vaxapp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User>findOneByUsername(String userName);
   //Optional<String> getCurrentUserUsername(Optional<String> username);
}
