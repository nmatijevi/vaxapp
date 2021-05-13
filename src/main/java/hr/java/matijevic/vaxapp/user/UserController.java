package hr.java.matijevic.vaxapp.user;


import hr.java.matijevic.vaxapp.security.DomainUserDetailsService;
import hr.java.matijevic.vaxapp.security.SecurityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/user", produces = "application/json")
@CrossOrigin(origins = "http://localhost:4200/%22")
public class UserController {

        private final DomainUserDetailsService domainUserDetailsService;
        private final ModelMapper modelMapper;
        private final UserServiceUser userService;

        public UserController(DomainUserDetailsService domainUserDetailsService, UserServiceUser userService) {
            this.domainUserDetailsService = domainUserDetailsService;
            this.userService = userService;
            this.modelMapper = new ModelMapper();
        }

    @GetMapping("/current-user")
    public ResponseEntity<UserDTO> getCurrentUser(){
        return SecurityUtils.getCurrentUserUsername().map(
                username -> userService.findOneByUsername(username).map
                        (ResponseEntity::ok).orElseGet(
                        () -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
                )
        ).orElseGet(
                () -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
        );
    }
}