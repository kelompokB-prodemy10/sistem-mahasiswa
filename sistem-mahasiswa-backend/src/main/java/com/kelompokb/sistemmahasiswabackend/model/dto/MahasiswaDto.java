package com.kelompokb.sistemmahasiswabackend.model.dto;

public class MahasiswaDto {

    private Integer idMhs;

    private String name;

    private Integer idJurusan;

    private Integer idUser;

    public Integer getIdMhs() {
        return idMhs;
    }

    public void setIdMhs(Integer idMhs) {
        this.idMhs = idMhs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(Integer idJurusan) {
        this.idJurusan = idJurusan;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
