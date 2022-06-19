package com.howtodoinjava.hibernate.test.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Clasa")
public class Clasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int idClasa;

    @Column(name = "Nume")
    private String numeClasa;


    @OneToOne
    private Profesor profesor;

    @OneToMany
    @JoinColumn(name = "Elev_Clasa")
    private List<Elev> elevList;


}
