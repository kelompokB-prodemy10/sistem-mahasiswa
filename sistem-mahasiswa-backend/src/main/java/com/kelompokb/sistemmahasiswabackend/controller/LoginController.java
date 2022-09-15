package com.kelompokb.sistemmahasiswabackend.controller;

import com.kelompokb.sistemmahasiswabackend.model.dto.DefaultResponse;
import com.kelompokb.sistemmahasiswabackend.model.dto.UserDto;
import com.kelompokb.sistemmahasiswabackend.model.entity.User;
import com.kelompokb.sistemmahasiswabackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/login")
    public DefaultResponse login(@RequestBody UserDto userDto) {
        DefaultResponse response = new DefaultResponse();
        Optional<User> optionalUser = userRepo.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
        if (optionalUser.isPresent()) {
            response.setStatus(Boolean.TRUE);
            response.setMessage("Login Berhasil");
            User user = optionalUser.get();
            userDto.setIdUser(user.getIdUser());
            userDto.setRole(user.getRole());
            response.setData(userDto);

        } else {
            response.setStatus(Boolean.FALSE);
            response.setMessage("Username atau Password Salah");
        }
        return response;
    }

    @GetMapping("/user/{idUser}")
    public UserDto getUserById(@PathVariable Integer idUser) {
        Optional<User> optionalUser = userRepo.findById(idUser);
        UserDto dto = new UserDto();
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            dto.setIdUser(user.getIdUser());
            dto.setUsername(user.getUsername());
            dto.setRole(user.getRole());
        }
        return dto;
    }

    @PostMapping("/register")
    public DefaultResponse<UserDto> saveUser(@RequestBody UserDto userDto) {
        User user = convertDtoToEntity(userDto);
        DefaultResponse<UserDto> df = new DefaultResponse<>();
        Optional<User> optionalUser = userRepo.findByUsername(userDto.getUsername());
        if (optionalUser.isPresent()) {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Gagal, Username Sudah Terdaftar");
        } else {
            userRepo.save(user);
            df.setStatus(Boolean.TRUE);
            df.setData(userDto);
            df.setMessage("Data Tersimpan");
        }
        return df;
    }

    public User convertDtoToEntity(UserDto userDto) {
        User user = new User();
        user.setIdUser(userDto.getIdUser());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        return user;
    }
}
