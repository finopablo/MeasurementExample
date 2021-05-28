package edu.utn.measurementexample.model.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;

public interface ReadingDTO {
    Integer getId();
    LocalDateTime getDate();
    Double getReading();
}
