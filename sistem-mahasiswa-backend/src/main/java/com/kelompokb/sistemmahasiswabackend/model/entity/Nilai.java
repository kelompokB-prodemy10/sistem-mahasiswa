package com.kelompokb.sistemmahasiswabackend.model.entity;


import javax.persistence.*;

@Entity
<<<<<<< HEAD
@Table(name = "tab_nilai")
public class Nilai {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
=======
@Table(name = "tab_haha")
public class Nilai {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
>>>>>>> d6dcbf569d939684292ff5a4b8fe90cc2f6364fa
    @Column(name = "id_nilai")
    private Integer idNilai;
    @Column(name = "id_mhs")
    private Integer idMhs;
    @Column(name = "id_ujian")
    private Integer idUjian;
    @Column(name = "nilai")
    private Integer Nilai;

<<<<<<< HEAD
    @OneToOne
    @JoinColumn(name = "id_ujian", insertable = false, updatable = false)
    private Ujian ujian;

    @OneToOne
    @JoinColumn(name = "id_mhs", insertable = false, updatable = false)
    private Mahasiswa mahasiswa;

=======
>>>>>>> d6dcbf569d939684292ff5a4b8fe90cc2f6364fa
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

    public Ujian getUjian() {
        return ujian;
    }

    public void setUjian(Ujian ujian) {
        this.ujian = ujian;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
}
