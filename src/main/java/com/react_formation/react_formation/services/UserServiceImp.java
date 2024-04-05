package com.react_formation.react_formation.services;

import com.react_formation.react_formation.DTO.requestsDTO.UserRequestDTO;
import com.react_formation.react_formation.DTO.responseDTO.UserResponseDTO;
import com.react_formation.react_formation.entities.User;
import com.react_formation.react_formation.mappers.UserMapper;
import com.react_formation.react_formation.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService{
    private  final UserRepository userRepository;
    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found with id: " + id));
        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public void saveUsser(UserRequestDTO userRequestDTO) {
        User user = UserMapper.INSTANCE.toEntity(userRequestDTO);
        user.setOwnedBooks(null);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("user not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, UserRequestDTO userRequestDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = UserMapper.INSTANCE.toEntity(userRequestDTO);
            user.setId(id);
            userRepository.save(user);
        } else {
            throw new RuntimeException("user not found with id: " + id);
        }
    }
}
