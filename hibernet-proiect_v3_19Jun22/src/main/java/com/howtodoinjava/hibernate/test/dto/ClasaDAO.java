package com.howtodoinjava.hibernate.test.dto;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ClasaDAO {
    public void insertClasa(Clasa clasa, Session session) {
        session.beginTransaction();
        session.persist(clasa);
        session.getTransaction().commit();
    }

    public List afisareClasa(Session session) {
        session.beginTransaction();
        Query fromClasa = session.createQuery("from Clasa ");
        List resultList = fromClasa.getResultList();
        session.getTransaction().commit();
        return resultList;
    }

    public void deleteClasa(Clasa clasa, Session session) {
        session.beginTransaction();
        session.delete(clasa);
        session.getTransaction().commit();
    }


    public void asignareProfesorPeClasa(Profesor profesor, Clasa clasa, Session session) {
        session.beginTransaction();
        //am setat profesor pe clasa
        //persist in baza de date
        clasa.setProfesor(profesor);
        session.persist(clasa);

        session.getTransaction().commit();
    }


    public Clasa cautareClasaDupaNume(String clasaCautataDupaNume, Session session) {
        Query queryClasa = session.createQuery("from Clasa c where c.numeClasa =:nume ");
        Query numeClasa = queryClasa.setParameter("nume", clasaCautataDupaNume);
        Clasa clasaReturnata = (Clasa) numeClasa.getResultList().get(0);

        return clasaReturnata;
    }

    public void asignareElev(Elev elev, Clasa clasa, Session session) {
        session.beginTransaction();

        clasa.getElevList().add(elev);
        session.persist(clasa);

        session.getTransaction().commit();

    }

}

