package com.howtodoinjava.hibernate.test.dto;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ElevDAO {

    public void insertElev(Elev elev, Session session) {
        session.beginTransaction();
        session.persist(elev);
        session.getTransaction().commit();
    }

    public void updateElev(Elev elev, Session session) {
        session.beginTransaction();
        Elev elevDinBazaDeDate = cautareElevDupaNume(elev, session);

        elevDinBazaDeDate.setPrenumeElev(elev.getPrenumeElev());
        elevDinBazaDeDate.setVarstaElev(elev.getVarstaElev());
        elevDinBazaDeDate.setMedieElev(elev.getMedieElev());
        session.persist(elevDinBazaDeDate);
        session.getTransaction().commit();
    }

    private Elev cautareElevDupaNume(Elev elev, Session session) {
        Query queryUpdate = session.createQuery("from Elev e where e.numeElev =:nume ");
        queryUpdate.setParameter("nume", elev.getNumeElev());
        Elev elevDinBazaDeDate = (Elev) queryUpdate.getResultList().get(0);
        return elevDinBazaDeDate;
    }

    public void deleteElev(Elev elev, Session session) {
        session.beginTransaction();
        session.delete(elev);
        session.getTransaction().commit();

    }

    public List afisareElev(Session session) {
        session.beginTransaction();
        Query queryAfisare = session.createQuery("from Elev");
        List resultList = queryAfisare.getResultList();
        session.getTransaction().commit();
        return resultList;
    }

    public List<Elev> findTotiEleviCuMediaMaiMareDecat7(Session session, double medie) {
        session.beginTransaction();
        Query queryAfisareCuConditie = session.createQuery("from Elev e where e.medieElev >:x ");
        queryAfisareCuConditie.setParameter("x", medie);
        List resultListMedie = queryAfisareCuConditie.getResultList();
        session.getTransaction().commit();
        return resultListMedie;
    }

    public Elev cautareElevDupaNume(String cautareaDupNume, Session session) {
        Query queryUpdate = session.createQuery("from Elev e where e.numeElev =:nume ");
        Query numeElev = queryUpdate.setParameter("nume", cautareaDupNume);
        Elev elevAsignat = (Elev) numeElev.getResultList().get(0);
        return elevAsignat;
    }

}
