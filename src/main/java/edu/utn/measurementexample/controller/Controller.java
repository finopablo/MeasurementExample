package edu.utn.measurementexample.controller;


import edu.utn.measurementexample.model.dto.ReadingDTO;
import edu.utn.measurementexample.persistence.ReadingsPersistence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/readings")
public class Controller {


    @Autowired
    ReadingsPersistence readingsPersistence;

    @GetMapping(produces = "application/json", params = {"from", "to", "meterId"})
    public ResponseEntity<List<ReadingDTO>> readingsBetween(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("meterId") Long meterId, Pageable pageable) {
        // Page<ReadingDTO> list = readingsPersistence.findByMeterIdAndDateBetween(meterId, LocalDate.parse(from).atStartOfDay(),LocalDate.parse(to).atStartOfDay(), pageable);
        // Page<ReadingDTO> list = readingsPersistence.getByMeterId(meterId, LocalDate.parse(from).atStartOfDay(), LocalDate.parse(to).atStartOfDay(), pageable);
         Page<ReadingDTO> list = readingsPersistence.getByMeterIdNative(meterId, LocalDate.parse(from).atStartOfDay(), LocalDate.parse(to).atStartOfDay(), pageable);
        return ResponseEntity.ok(list.getContent());
    }

}
