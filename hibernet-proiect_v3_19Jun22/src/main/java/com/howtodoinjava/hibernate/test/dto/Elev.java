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
@Table(name = "Elev")
public class Elev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int idElev;

    @Column(name = "Nume")
    private String numeElev;

    @Column(name = "Prenume")
    private String prenumeElev;

    @Column(name = "Varsta")
    private int varstaElev;

    @Column(name = "Medie")
    private double medieElev;


}
