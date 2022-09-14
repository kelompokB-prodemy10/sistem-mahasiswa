package com.kelompokb.sistemmahasiswabackend.controller;

import com.kelompokb.sistemmahasiswabackend.model.dto.DefaultResponse;
import com.kelompokb.sistemmahasiswabackend.model.dto.MahasiswaDto;
import com.kelompokb.sistemmahasiswabackend.model.entity.Mahasiswa;
import com.kelompokb.sistemmahasiswabackend.repository.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaRepo mahasiswaRepo;

    @PostMapping("/savedata")
    public DefaultResponse<MahasiswaDto> saveMahasiswa(@RequestBody MahasiswaDto mahasiswaDto) {
        Mahasiswa mahasiswa = convertDtoToEntity(mahasiswaDto);
        DefaultResponse<MahasiswaDto> df = new DefaultResponse<>();
        Optional<Mahasiswa> optionalMahasiswa = mahasiswaRepo.findById(mahasiswaDto.getIdMhs());
        if (optionalMahasiswa.isPresent()) {
            df.setStatus(Boolean.FALSE);
            df.setPesan("Gagal, Data Sudah Terdaftar");
        } else {
            mahasiswaRepo.save(mahasiswa);
            df.setStatus(Boolean.TRUE);
            df.setData(mahasiswaDto);
            df.setPesan("Data Tersimpan");
        }
        return df;
    }

    @GetMapping("/listmhs")
    public List<MahasiswaDto> getListMahasiswa() {
        List<MahasiswaDto> list = new ArrayList();
        for (Mahasiswa i : mahasiswaRepo.findAll()) {
            list.add(convertEntityToDto(i));
        }
        return list;
    }

    @PutMapping("/update/{idMhs}")
    public DefaultResponse update(@PathVariable Integer idMhs, @RequestBody MahasiswaDto mahasiswaDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Mahasiswa> optionalMahasiswa = mahasiswaRepo.findById(idMhs);
        Mahasiswa mahasiswa = optionalMahasiswa.get();
        if (optionalMahasiswa.isPresent()) {
            mahasiswa.setIdMhs(mahasiswaDto.getIdMhs());
            mahasiswa.setName(mahasiswaDto.getName());
            mahasiswa.setIdJurusan(mahasiswaDto.getIdJurusan());
            mahasiswa.setIdUser(mahasiswaDto.getIdUser());
            mahasiswaRepo.save(mahasiswa);
            df.setStatus(Boolean.TRUE);
            df.setData(mahasiswaDto);
            df.setPesan("Perubahan Berhasil Tersimpan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setPesan("ID Tidak Ditemukan");
        }
        return df;
    }

    @DeleteMapping("/delete/{idMhs}")
    public DefaultResponse deletById(@PathVariable Integer idMhs) {
        DefaultResponse df = new DefaultResponse();
        Optional<Mahasiswa> optionalMahasiswa = mahasiswaRepo.findById(idMhs);
        if (optionalMahasiswa.isPresent()) {
            mahasiswaRepo.delete(optionalMahasiswa.get());
            df.setStatus(Boolean.TRUE);
            df.setPesan("Data Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setPesan("Data Tidak Ditemukan");
        }
        return df;
    }

    public MahasiswaDto convertEntityToDto(Mahasiswa entity) {
        MahasiswaDto dto = new MahasiswaDto();
        dto.setIdMhs(entity.getIdMhs());
        dto.setName(entity.getName());
        dto.setIdJurusan(entity.getIdJurusan());
        dto.setNamaJurusan(entity.getJurusan().getNamaJurusan());
        dto.setIdUser(entity.getIdUser());
        dto.setUsername(entity.getUser().getUsername());
        dto.setRole(entity.getUser().getRole());

        return dto;
    }

    public Mahasiswa convertDtoToEntity(MahasiswaDto mahasiswaDto) {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setIdMhs(mahasiswaDto.getIdMhs());
        mahasiswa.setName(mahasiswaDto.getName());
        mahasiswa.setIdJurusan(mahasiswaDto.getIdJurusan());
        mahasiswa.setIdUser(mahasiswaDto.getIdUser());

        return mahasiswa;
    }
}
