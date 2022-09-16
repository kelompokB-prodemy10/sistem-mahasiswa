package com.kelompokb.sistemmahasiswabackend.repository;

import com.kelompokb.sistemmahasiswabackend.model.entity.Nilai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NilaiRepo extends JpaRepository<Nilai, Integer> {
<<<<<<< HEAD
    Optional<Nilai> findByIdMhs(Integer idMhs);

    Optional<Nilai> findByIdUjian(Integer idUjian);
=======
    Optional<Nilai> findById(Integer idNilai);
>>>>>>> d6dcbf569d939684292ff5a4b8fe90cc2f6364fa
}
