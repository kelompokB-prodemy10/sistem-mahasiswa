package com.kelompokb.sistemmahasiswabackend.model.entity;


import com.kelompokb.sistemmahasiswabackend.model.dto.NilaiDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tab_nilai")
public class Nilai extends NilaiDto {

    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_nilai")
    private Integer idNilai;
    @Column(name = "id_mhs")
    private Integer idMhs;
    @Column(name = "id_ujian")
    private Integer idUjian;
    @Column(name = "nilai")
    private Integer Nilai;

    @Override
    public Integer getIdNilai() {
        return idNilai;
    }

    @Override
    public void setIdNilai(Integer idNilai) {
        this.idNilai = idNilai;
    }

    @Override
    public Integer getIdMhs() {
        return idMhs;
    }

    @Override
    public void setIdMhs(Integer idMhs) {
        this.idMhs = idMhs;
    }

    @Override
    public Integer getIdUjian() {
        return idUjian;
    }

    @Override
    public void setIdUjian(Integer idUjian) {
        this.idUjian = idUjian;
    }

    @Override
    public Integer getNilai() {
        return Nilai;
    }

    @Override
    public void setNilai(Integer nilai) {
        Nilai = nilai;
    }
}
