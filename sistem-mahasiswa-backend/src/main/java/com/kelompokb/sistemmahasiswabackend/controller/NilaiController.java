package com.kelompokb.sistemmahasiswabackend.controller;


import com.kelompokb.sistemmahasiswabackend.model.dto.DefaultResponse;
import com.kelompokb.sistemmahasiswabackend.model.dto.NilaiDto;
import com.kelompokb.sistemmahasiswabackend.model.entity.Nilai;
import com.kelompokb.sistemmahasiswabackend.repository.MahasiswaRepo;
import com.kelompokb.sistemmahasiswabackend.repository.NilaiRepo;
import com.kelompokb.sistemmahasiswabackend.repository.UjianRepo;
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
    @Autowired
    private MahasiswaRepo mahasiswaRepo;
    @Autowired
    private UjianRepo ujianRepo;

    @PostMapping("/savenilai") //save nilai dengan autogenerate OKE
    public DefaultResponse<NilaiDto> saveNilai (@RequestBody NilaiDto nilaiDto) {
        Nilai nilai = convertDtoToEntity(nilaiDto);
        DefaultResponse<NilaiDto> df = new DefaultResponse<>();
        Optional<Nilai> optionalMhs  = nilaiRepo.findByIdMhs(nilaiDto.getIdMhs());
        Optional<Nilai> optionalUjian = nilaiRepo.findByIdUjian(nilaiDto.getIdUjian());
        if (optionalMhs.isPresent() && optionalUjian.isPresent()) {
            df.setStatus(Boolean.FALSE);
            df.setPesan("Gagal, Data Nilai Sudah Terdaftar");
        } else {
            nilaiRepo.save(nilai);
            df.setStatus(Boolean.TRUE);
            df.setData(nilaiDto);
            df.setPesan("Data Nilai Tersimpan");
        }
        return df;
    }
    @GetMapping("/listnilai") //list nilai OKE
    public List<Nilai> getListNilai() {
        List<Nilai> list = new ArrayList<>();
        for (Nilai nilai : nilaiRepo.findAll()) {
        list.add(convertEntityToDto(nilai));
    }
    return list;
    }
    @GetMapping("/getnilai/{idNilai}")
    public NilaiDto getById(@PathVariable Integer idNilai){
        Optional<Nilai> optionalNilai = nilaiRepo.findById(idNilai);
        NilaiDto dto = new NilaiDto();
        if (optionalNilai.isPresent()){
            Nilai entity = optionalNilai.get();
            dto.setIdNilai(entity.getIdNilai());
            dto.setIdMhs(entity.getIdMhs());
            dto.setIdUjian(entity.getIdUjian());
            dto.setNilai(entity.getNilai());
        }
        return dto;
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
            df.setPesan("Perubahan Berhasil Tersimpan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setPesan("ID Tidak Ditemukan");
        }
        return df;
    }

    @DeleteMapping("/delete{idNilai}")
    public DefaultResponse deleteById (@PathVariable Integer idNilai) {
        DefaultResponse df = new DefaultResponse();
        Optional<Nilai> nilaiOptional = nilaiRepo.findById(idNilai) ;
        if (nilaiOptional.isPresent()) {
            nilaiRepo.delete(nilaiOptional.get());
            df.setStatus(Boolean.TRUE);
            df.setPesan("Data Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setPesan("Data Tidak Ditemukan");
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
    public Nilai convertEntityToDto(Nilai entity){
        Nilai dto = new Nilai();
        dto.setIdNilai(entity.getIdNilai());
        dto.setIdMhs(entity.getIdMhs());
        dto.setIdUjian(entity.getIdUjian());
        dto.setNilai(entity.getNilai());

        return dto;
    }
}
