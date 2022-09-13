package com.kelompokb.sistemmahasiswabackend.controller;

import com.kelompokb.sistemmahasiswabackend.model.dto.DefaultResponse;
import com.kelompokb.sistemmahasiswabackend.model.dto.LoginDto;
import com.kelompokb.sistemmahasiswabackend.model.entity.User;
import com.kelompokb.sistemmahasiswabackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/login")
    public DefaultResponse login(@RequestBody LoginDto loginDto) {
        DefaultResponse response = new DefaultResponse();
        Optional<User> optionalKaryawanUsername = userRepo.findByUsername(loginDto.getUsername());
        Optional<User> optionalKaryawanPassword = userRepo.findByPassword(loginDto.getPassword());
        if (optionalKaryawanUsername.isPresent()) {
            if (optionalKaryawanPassword.isPresent()) {
                response.setStatus(Boolean.TRUE);
                response.setPesan("Login Berhasil");
            } else {
                response.setStatus(Boolean.FALSE);
                response.setPesan("Password Salah");
            }
        } else {
            response.setStatus(Boolean.FALSE);
            response.setPesan("Username Tidak Terdaftar");
        }
        return response;
    }


}

