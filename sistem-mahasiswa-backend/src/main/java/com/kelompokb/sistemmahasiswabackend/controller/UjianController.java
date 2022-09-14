package com.kelompokb.sistemmahasiswabackend.controller;

import com.kelompokb.sistemmahasiswabackend.model.dto.DefaultResponse;
import com.kelompokb.sistemmahasiswabackend.model.dto.UjianDto;
import com.kelompokb.sistemmahasiswabackend.model.entity.Ujian;
import com.kelompokb.sistemmahasiswabackend.repository.UjianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ujian")
public class UjianController {

    @Autowired
    private UjianRepo ujianRepo;

    @PostMapping("/savedata")
    public DefaultResponse<UjianDto> saveUjian (@RequestBody UjianDto ujianDto) {
        Ujian ujian = convertDtoToEntity(ujianDto);
        DefaultResponse<UjianDto> df = new DefaultResponse<>();
        Optional<Ujian> optionalUjian = ujianRepo.findById(ujianDto.getIdUjian());
        if (optionalUjian.isPresent()) {
            df.setStatus(Boolean.FALSE);
            df.setPesan("Gagal, Data Ujian Sudah Terdaftar");
        } else {
            ujianRepo.save(ujian);
            df.setStatus(Boolean.TRUE);
            df.setData(ujianDto);
            df.setPesan("Data Ujian Tersimpan");
        }
        return df;
    }
    @GetMapping("/listujian")
    public List<UjianDto> getListUjian(){
       List<UjianDto> list = new ArrayList<>();
       for (Ujian ujian : ujianRepo.findAll()){
           list.add(convertEntityToDto(ujian));
       }
       return list;
}
    @PutMapping("/update/{idUjian}")
    public DefaultResponse update(@PathVariable Integer idUjian, @RequestBody UjianDto ujianDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Ujian> ujianOptional = ujianRepo.findById(idUjian);
        Ujian ujian = ujianOptional.get();
        if (ujianOptional.isPresent()) {
            ujian.setIdUjian(ujianDto.getIdUjian());
            ujian.setJudulUjian(ujianDto.getJudulUjian());
            ujian.setIdMatkul(ujianDto.getIdMatkul());
            ujian.setStatUjian(ujianDto.getStatUjian());
            ujianRepo.save(ujian);
            df.setStatus(Boolean.TRUE);
            df.setData(ujianDto);
            df.setPesan("Perubahan Berhasil Tersimpan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setPesan("ID Tidak Ditemukan");
        }
        return df;
    }

    @DeleteMapping("/delete/{idDosen}")
    public DefaultResponse deleteById (@PathVariable Integer ujianId) {
        DefaultResponse df = new DefaultResponse();
        Optional<Ujian> ujianOptional = ujianRepo.findById(ujianId) ;
        if (ujianOptional.isPresent()) {
            ujianRepo.delete(ujianOptional.get());
            df.setStatus(Boolean.TRUE);
            df.setPesan("Data Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setPesan("Data Tidak Ditemukan");
        }
        return df;
    }

    public Ujian convertDtoToEntity (UjianDto dto){
        Ujian ujian = new Ujian();
        ujian.setIdUjian(dto.getIdUjian());
        ujian.setJudulUjian(dto.getJudulUjian());
        ujian.setIdMatkul(dto.getIdMatkul());
        ujian.setStatUjian(dto.getStatUjian());

        return ujian;
    }
    public Ujian convertEntityToDto(Ujian dto){
        Ujian ujian = new Ujian();
        ujian.setIdUjian(dto.getIdUjian());
        ujian.setJudulUjian(dto.getJudulUjian());
        ujian.setIdMatkul(dto.getIdMatkul());
        ujian.setStatUjian(dto.getStatUjian());

        return ujian;
    }
}
