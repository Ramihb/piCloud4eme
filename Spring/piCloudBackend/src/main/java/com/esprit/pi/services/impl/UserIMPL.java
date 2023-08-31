package com.esprit.pi.services.impl;

import com.esprit.pi.dto.LoginDTO;
import com.esprit.pi.dto.UserDTO;
import com.esprit.pi.entities.UserEntity;
import com.esprit.pi.repositories.UserRepository;
import com.esprit.pi.response.LoginMessage;
import com.esprit.pi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(
                userDTO.getUserId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getPhoneNumber(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        userRepository.save(userEntity);
        return userEntity.getFirstName();
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        UserEntity user1 = userRepository.findByEmail(loginDTO.getEmail());
        if(user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if(isPwdRight) {
                Optional<UserEntity> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if(user.isPresent()) {
                    return new LoginMessage("Login success", true);
                } else {
                    return new LoginMessage("Login failed", false);
                }
            } else {
                return new LoginMessage("password don't match", false);
            }
        } else {
            return new LoginMessage("Email don't exist", false);
        }
    }
}
