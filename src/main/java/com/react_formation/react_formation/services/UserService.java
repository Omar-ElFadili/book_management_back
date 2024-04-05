package com.react_formation.react_formation.services;

import com.react_formation.react_formation.DTO.requestsDTO.UserRequestDTO;
import com.react_formation.react_formation.DTO.responseDTO.UserResponseDTO;

import java.util.List;

public interface UserService {
    public List<UserResponseDTO> getAllUsers();

    public UserResponseDTO getUserById(Long id);

    public void saveUsser(UserRequestDTO userRequestDTO);

    public void deleteUser(Long id);

    void updateUser(Long id, UserRequestDTO userRequestDTO);
}
