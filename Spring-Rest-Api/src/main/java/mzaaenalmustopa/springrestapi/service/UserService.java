package mzaaenalmustopa.springrestapi.service;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import mzaaenalmustopa.springrestapi.entity.User;
import mzaaenalmustopa.springrestapi.model.RegisterUserRequest;
import mzaaenalmustopa.springrestapi.model.UpdateUserRequest;
import mzaaenalmustopa.springrestapi.model.UserResponse;
import mzaaenalmustopa.springrestapi.repository.UserRepository;
import mzaaenalmustopa.springrestapi.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void register(RegisterUserRequest request) {
        validationService.validate(request);

        if (userRepository.existsById(request.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }

    public UserResponse get(User user){
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }


    @Transactional
    public UserResponse update(User user, UpdateUserRequest request){
        validationService.validate(request);

        log.info("Request {}", request);

        if (Objects.nonNull(request.getName())){
            user.setName(request.getName());
        }

        if (Objects.nonNull(request.getPassword())){
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }

        log.info("User {}", user.getName());

        userRepository.save(user);

        return UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }
}
