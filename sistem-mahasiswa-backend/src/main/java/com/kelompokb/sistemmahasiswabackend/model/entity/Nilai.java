package com.kelompokb.sistemmahasiswabackend.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "tab_haha")
public class Nilai {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_nilai")
    private Integer idNilai;
    @Column(name = "id_mhs")
    private Integer idMhs;
    @Column(name = "id_ujian")
    private Integer idUjian;
    @Column(name = "nilai")
    private Integer Nilai;

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
