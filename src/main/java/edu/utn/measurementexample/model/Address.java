package edu.utn.measurementexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column
    String street;

    @Column
    Integer number;

    @Column
    String apartment;

    @ManyToOne
    @JoinColumn(name = "client", nullable = false, updatable = false)
    Client client;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.LAZY)
    List<Meter> meters;


}
