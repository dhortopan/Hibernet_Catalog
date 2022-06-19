package com.howtodoinjava.hibernate.test.dto;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProfesorDAO {
    public void insertProfesor(Profesor profesor, Session session) {
        session.beginTransaction();
        session.persist(profesor);
        session.getTransaction().commit();
    }

    public void deleteProfesor(Profesor profesor, Session session) {
        session.beginTransaction();
        session.delete(profesor);
        session.getTransaction().commit();
    }

    public List<Profesor> afisareProfesor(Profesor profesor, Session session) {
        session.beginTransaction();
        Query from_profesor = session.createQuery("from Profesor");
        List resultList = from_profesor.getResultList();
        session.getTransaction().commit();
        return resultList;
    }

    public Profesor cautareProfesorDupaNume(String cautareaDupNume, Session session) {
        Query queryUpdate = session.createQuery("from Profesor p where p.numeProfesor =:nume ");
        Query numeProfesor = queryUpdate.setParameter("nume", cautareaDupNume);
        Profesor profesorAsignat = (Profesor) numeProfesor.getResultList().get(0);
        return profesorAsignat;
    }

    public void updateProfesorDupaNume(Profesor profesor, Session session) {
        session.beginTransaction();
        Profesor profesorAsignat = cautareProfesorDupaNume(profesor.getNumeProfesor(), session);
        profesorAsignat.setPreNumeProfesor(profesor.getPreNumeProfesor());
        profesorAsignat.setMateriePredata(profesor.getMateriePredata());
        session.persist(profesorAsignat);
        session.getTransaction().commit();

    }
}
