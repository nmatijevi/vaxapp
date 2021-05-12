package hr.java.matijevic.vaxapp.user;


import hr.java.matijevic.vaxapp.security.DomainUserDetailsService;
import hr.java.matijevic.vaxapp.security.SecurityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/user", produces = "application/json")
@CrossOrigin(origins = "http://localhost:4200/%22")
public class UserController {

        private final DomainUserDetailsService domainUserDetailsService;
        private final ModelMapper modelMapper;

        public UserController(DomainUserDetailsService domainUserDetailsService) {
            this.domainUserDetailsService = domainUserDetailsService;
            this.modelMapper = new ModelMapper();
        }

    @GetMapping("/current-user")
    public ResponseEntity<UserDTO> getCurrentUser() {
        Optional<String> username = SecurityUtils.getCurrentUserUsername();
        UserDetails userDetails = domainUserDetailsService.loadUserByUsername(username.get());
        return new ResponseEntity<>(modelMapper.map(userDetails, UserDTO.class), HttpStatus.OK);

}
}