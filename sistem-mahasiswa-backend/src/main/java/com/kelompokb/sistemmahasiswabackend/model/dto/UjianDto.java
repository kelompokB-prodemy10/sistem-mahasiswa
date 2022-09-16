package com.kelompokb.sistemmahasiswabackend.model.dto;

public class UjianDto {

    private Integer idUjian;
    private Integer idMatkul;
    private String judulUjian;
    private String statUjian;
    private String namaMatkul;

    public Integer getIdUjian() {
        return idUjian;
    }

    public void setIdUjian(Integer idUjian) {
        this.idUjian = idUjian;
    }

    public Integer getIdMatkul() {
        return idMatkul;
    }

    public void setIdMatkul(Integer idMatkul) {
        this.idMatkul = idMatkul;
    }

    public String getJudulUjian() {
        return judulUjian;
    }

    public void setJudulUjian(String judulUjian) {
        this.judulUjian = judulUjian;
    }

    public String getStatUjian() {
        return statUjian;
    }

    public void setStatUjian(String statUjian) {
        this.statUjian = statUjian;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }
}
