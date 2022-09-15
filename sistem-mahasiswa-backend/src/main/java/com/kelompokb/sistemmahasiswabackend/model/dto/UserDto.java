package com.kelompokb.sistemmahasiswabackend.model.dto;

public class UserDto {

    private Integer idUser;
    private String username;
    private String password;
    private String role;

    public Integer getIdUser() {
        return idUser;
    }

    public Object setIdUser(Integer idUser) {
        this.idUser = idUser;
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public Object setRole(String role) {
        this.role = role;
        return role;
    }
}
