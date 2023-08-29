package com.esprit.pi.services;

import com.esprit.pi.dto.LoginDTO;
import com.esprit.pi.dto.UserDTO;
import com.esprit.pi.response.LoginMessage;

public interface UserService {
    public String addUser(UserDTO userDTO);
    LoginMessage loginUser(LoginDTO loginDTO);
}
