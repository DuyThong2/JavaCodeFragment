package com.example.AuthenticateAPI.service;

import com.example.AuthenticateAPI.dto.UsersDTO;
import com.example.AuthenticateAPI.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UsersRepository userRepository;

    public List<UsersDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UsersDTO dto = new UsersDTO();
            dto.setId(user.getId());
            dto.setEmail(user.getEmail());
            dto.setUsername(user.getUsername());
            dto.setFullName(user.getFullName());
            dto.setRoleString(user.getRole().getRoleName());
            dto.setBirthDate(user.getBirthDate());
            dto.setAvatar(user.getAvatar());
            dto.setAddress(user.getAddress());
            dto.setPhone(user.getPhone());
            dto.setGender(user.getGender());
            dto.setDateCreated(user.getDateCreated());
            dto.setDateUpdated(user.getDateUpdated());
            dto.setAvailableStatus(user.getAvailableStatus());
            dto.setOtpCode(user.getOtpCode());
            return dto;
        }).collect(Collectors.toList());
    }
}
