package com.kelompokb.sistemmahasiswabackend.controller;


import com.kelompokb.sistemmahasiswabackend.model.dto.DefaultResponse;
import com.kelompokb.sistemmahasiswabackend.model.dto.NilaiDto;
import com.kelompokb.sistemmahasiswabackend.model.entity.Nilai;
import com.kelompokb.sistemmahasiswabackend.repository.NilaiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nilai")
public class NilaiController {

    @Autowired
    private NilaiRepo nilaiRepo;

    @PostMapping("/savenilai")
    public DefaultResponse<NilaiDto> saveNilai (@RequestBody NilaiDto nilaiDto) {
        Nilai nilai = convertDtoToEntity(nilaiDto);
        DefaultResponse<NilaiDto> df = new DefaultResponse<>();
        Optional<Nilai> optionalNilai  = nilaiRepo.findById(nilaiDto.getIdNilai());
        if (optionalNilai.isPresent()) {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Gagal, Data Nilai Sudah Terdaftar");
        } else {
            nilaiRepo.save(nilai);
            df.setStatus(Boolean.TRUE);
            df.setData(nilaiDto);
            df.setMessage("Data Nilai Tersimpan");
        }
        return df;
    }
    @GetMapping("/listnilai")
    public List<NilaiDto> getListNilai(){
        List<NilaiDto> list = new ArrayList<>();
        for (Nilai nilai : nilaiRepo.findAll()){
            list.add(convertEntityToDto(nilai));
        }
        return list;
    }
    @PutMapping("/update/{idNilai}")
    public DefaultResponse update(@PathVariable Integer idNilai, @RequestBody NilaiDto nilaiDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Nilai> nilaiOptional = nilaiRepo.findById(idNilai);
        Nilai nilai = nilaiOptional.get();
        if (nilaiOptional.isPresent()) {
            nilai.setIdNilai(nilaiDto.getIdNilai());
            nilai.setIdMhs(nilaiDto.getIdMhs());
            nilai.setIdUjian(nilaiDto.getIdUjian());
            nilai.setNilai(nilaiDto.getNilai());
            nilaiRepo.save(nilai);
            df.setStatus(Boolean.TRUE);
            df.setData(nilaiDto);
            df.setMessage("Perubahan Berhasil Tersimpan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("ID Tidak Ditemukan");
        }
        return df;
    }

    @DeleteMapping("/delete/{idNilai}")
    public DefaultResponse deleteById (@PathVariable Integer idNilai) {
        DefaultResponse df = new DefaultResponse();
        Optional<Nilai> nilaiOptional = nilaiRepo.findById(idNilai) ;
        if (nilaiOptional.isPresent()) {
            nilaiRepo.delete(nilaiOptional.get());
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Tidak Ditemukan");
        }
        return df;
    }

    public Nilai convertDtoToEntity (NilaiDto dto){
        Nilai nilai = new Nilai();
        nilai.setIdNilai(dto.getIdNilai());
        nilai.setIdMhs(dto.getIdMhs());
        nilai.setIdUjian(dto.getIdUjian());
        nilai.setNilai(dto.getNilai());

        return nilai;
    }
    public Nilai convertEntityToDto(Nilai dto){
        Nilai nilai = new Nilai();
        nilai.setIdNilai(dto.getIdNilai());
        nilai.setIdMhs(dto.getIdMhs());
        nilai.setIdUjian(dto.getIdUjian());
        nilai.setNilai(dto.getNilai());

        return nilai;
    }
}
