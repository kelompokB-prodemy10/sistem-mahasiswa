package com.kelompokb.sistemmahasiswabackend.controller;

import com.kelompokb.sistemmahasiswabackend.model.dto.DefaultResponse;
import com.kelompokb.sistemmahasiswabackend.model.dto.DosenDto;
import com.kelompokb.sistemmahasiswabackend.model.entity.Dosen;
import com.kelompokb.sistemmahasiswabackend.repository.DosenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dosen")
public class DosenController {

    @Autowired
    private DosenRepo dosenRepo;

    @PostMapping("/savedata")
    public DefaultResponse<DosenDto> saveDosen(@RequestBody DosenDto dosenDto) {
        Dosen dosen = convertDtoToEntity(dosenDto);
        DefaultResponse<DosenDto> df = new DefaultResponse<>();
        dosenRepo.save(dosen);
        df.setStatus(Boolean.TRUE);
        df.setData(dosenDto);
        df.setMessage("Data Tersimpan");
        return df;
    }

    @GetMapping("/listdosen")
    public List<DosenDto> getListDosen() {
        List<DosenDto> list = new ArrayList();
        for (Dosen i : dosenRepo.findAll()) {
            list.add(convertEntityToDto(i));
        }
        return list;
    }

    @PutMapping("/update/{idDosen}")
    public DefaultResponse update(@PathVariable Integer idDosen, @RequestBody DosenDto dosenDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Dosen> optionalDosen = dosenRepo.findById(idDosen);
        Dosen dosen = optionalDosen.get();
        if (optionalDosen.isPresent()) {
            dosen.setIdDosen(dosenDto.getIdDosen());
            dosen.setName(dosenDto.getName());
            dosen.setIdJurusan(dosenDto.getIdJurusan());
            dosen.setIdUser(dosenDto.getIdUser());
            dosenRepo.save(dosen);
            df.setStatus(Boolean.TRUE);
            df.setData(dosenDto);
            df.setMessage("Perubahan Berhasil Tersimpan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("ID Tidak Ditemukan");
        }
        return df;
    }

    @DeleteMapping("/delete/{idDosen}")
    public DefaultResponse deletById(@PathVariable Integer idDosen) {
        DefaultResponse df = new DefaultResponse();
        Optional<Dosen> optionalDosen = dosenRepo.findById(idDosen);
        if (optionalDosen.isPresent()) {
            dosenRepo.delete(optionalDosen.get());
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Tidak Ditemukan");
        }
        return df;
    }

    public DosenDto convertEntityToDto(Dosen entity) {
        DosenDto dto = new DosenDto();
        dto.setIdDosen(entity.getIdDosen());
        dto.setName(entity.getName());
        dto.setIdJurusan(entity.getIdJurusan());
        dto.setNamaJurusan(entity.getJurusan().getNamaJurusan());
        dto.setIdUser(entity.getIdUser());
        dto.setUsername(entity.getUser().getUsername());
        dto.setRole(entity.getUser().getRole());


        return dto;
    }

    public Dosen convertDtoToEntity(DosenDto dosenDto) {
        Dosen dosen = new Dosen();
        dosen.setIdDosen(dosenDto.getIdDosen());
        dosen.setName(dosenDto.getName());
        dosen.setIdJurusan(dosenDto.getIdJurusan());
        dosen.setIdUser(dosenDto.getIdUser());

        return dosen;
    }
}
