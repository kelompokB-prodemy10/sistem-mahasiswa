package com.kelompokb.sistemmahasiswabackend.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_dosen")
public class Dosen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dosen_generator")
    @SequenceGenerator(name = "dosen_generator", sequenceName = "seq_dosen", initialValue = 1, allocationSize = 1)
    @Column(name = "id_dosen")
    private Integer idDosen;

    private String name;

    @Column(name = "id_jurusan")
    private String idJurusan;

    @Column(name = "id_user")
    private String idUser;

    public Integer getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(Integer idDosen) {
        this.idDosen = idDosen;
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
