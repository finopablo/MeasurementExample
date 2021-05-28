package edu.utn.measurementexample.persistence;


import edu.utn.measurementexample.model.Reading;
import edu.utn.measurementexample.model.dto.ReadingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ReadingsPersistence extends CrudRepository<Reading, Long> {
        Page<ReadingDTO> findByMeterIdAndDateBetween(Long meterId, LocalDateTime from , LocalDateTime to, Pageable pageable);
        @Query("SELECT r from Reading r where  meter.id = ?1 AND date between ?2 and ?3")
        Page<ReadingDTO> getByMeterId(Long meterId, LocalDateTime from , LocalDateTime to, Pageable pageable);


        @Query(value = "SELECT * from reading r where  r.meter = ?1 AND r.date between ?2 and ?3 order by date desc",
                countQuery = "select count(*) from reading r where  r.meter = ?1 AND r.date between ?2 and ?3",
                        nativeQuery = true)
        Page<ReadingDTO> getByMeterIdNative(Long meterId, LocalDateTime from , LocalDateTime to, Pageable pageable);
}
