package ro.arcgis.mures.mures.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.arcgis.mures.mures.Constants;
import ro.arcgis.mures.mures.models.User;
import ro.arcgis.mures.mures.models.UserLoginDto;
import ro.arcgis.mures.mures.repositories.UserRepository;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = UserController.USER_CONTROOLER_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    public static final String USER_CONTROOLER_PATH = Constants.API_PATH + "/users";

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/register")
    @ResponseBody
    ResponseEntity<User> register(@Valid @RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    @ResponseBody
    ResponseEntity<User> login(@Valid @RequestBody UserLoginDto user) throws AuthenticationException {
        User userFromDB = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if(userFromDB == null) {
            throw new AuthenticationException("User with provided username and password not found");
        }

        return new ResponseEntity<>(userFromDB, HttpStatus.OK);
    }
}
