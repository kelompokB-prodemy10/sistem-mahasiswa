package com.kelompokb.sistemmahasiswabackend.model.entity;

import com.kelompokb.sistemmahasiswabackend.model.dto.UjianDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tab_ujian")
public class Ujian {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @SequenceGenerator(name = "seq_ujian", sequenceName = "seq_ujian", initialValue = 1, allocationSize = 1)

   @Column(name = "id_ujian")
    private Integer idUjian;

    @Column(name = "id_matkul")
    private Integer idMatkul;

    @OneToOne
    @JoinColumn(name = "id_matkul", insertable = false, updatable = false)
    private Matkul matkul;

    @Column(name = "judul_ujian")
    private String judulUjian;

    @Column(name = "stat_ujian")
    private String statUjian;

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

    public Matkul getMatkul() {
        return matkul;
    }

    public void setMatkul(Matkul matkul) {
        this.matkul = matkul;
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
}
