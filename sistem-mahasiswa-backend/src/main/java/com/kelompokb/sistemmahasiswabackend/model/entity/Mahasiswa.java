package com.kelompokb.sistemmahasiswabackend.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_mhs")
public class Mahasiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mhs_generator")
    @SequenceGenerator(name = "mhs_generator", sequenceName = "seq_mhs", initialValue = 1, allocationSize = 1)
    @Column(name = "id_mhs")
    private Integer idMhs;

    private String name;

    @Column(name = "id_jurusan")
    private String idJurusan;

    @Column(name = "id_user")
    private String idUser;

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

    public String getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(String idJurusan) {
        this.idJurusan = idJurusan;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
