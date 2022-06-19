package com.howtodoinjava.hibernate.test.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int idProfesor;

    @Column(name = "Nume")
    private String numeProfesor;

    @Column(name = "preNume")
    private String preNumeProfesor;

    @Column(name = "Materie")
    private String materiePredata;


}
