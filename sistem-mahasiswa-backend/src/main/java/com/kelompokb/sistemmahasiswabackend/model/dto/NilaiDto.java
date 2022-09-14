package com.kelompokb.sistemmahasiswabackend.model.dto;

public class NilaiDto {

    private Integer idNilai;
    private Integer idMhs;
    private Integer idUjian;
    private  Integer Nilai;

    public Integer getIdNilai() {
        return idNilai;
    }

    public void setIdNilai(Integer idNilai) {
        this.idNilai = idNilai;
    }

    public Integer getIdMhs() {
        return idMhs;
    }

    public void setIdMhs(Integer idMhs) {
        this.idMhs = idMhs;
    }

    public Integer getIdUjian() {
        return idUjian;
    }

    public void setIdUjian(Integer idUjian) {
        this.idUjian = idUjian;
    }

    public Integer getNilai() {
        return Nilai;
    }

    public void setNilai(Integer nilai) {
        Nilai = nilai;
    }
}
