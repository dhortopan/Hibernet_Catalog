package com.howtodoinjava.hibernate.test;

import com.howtodoinjava.hibernate.test.dto.*;
import org.hibernate.Session;

import java.util.Scanner;

public class TestHibernate {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Scanner input = new Scanner(System.in);


        System.out.println("Introduceti optiunea:");
        int optiune = 0;

        do {
            optiune = input.nextInt();
            switch (optiune) {
                case 1 -> {
                    //insert Elev
                    Elev elev = new Elev();
                    System.out.println("Introduceti numele elevului");
                    elev.setNumeElev(input.next());
                    System.out.println("Introduceti prenumele elevului");
                    elev.setPrenumeElev(input.next());
                    System.out.println("Introduceti varsta elevului");
                    elev.setVarstaElev(input.nextInt());
                    System.out.println("Introduceti media elevului");
                    elev.setMedieElev(input.nextDouble());

                    ElevDAO elevDAO = new ElevDAO();
                    elevDAO.insertElev(elev, session);
                }

                case 2 -> {
                    // insert Profesor
                    Profesor profesor = new Profesor();
                    System.out.println("Introduceti numele profesorului");
                    profesor.setNumeProfesor(input.next());
                    System.out.println("Introduceti preNumele profesorului");
                    profesor.setPreNumeProfesor(input.next());
                    System.out.println("Introduceti materia");
                    profesor.setMateriePredata(input.next());

                    ProfesorDAO profesorDAO = new ProfesorDAO();
                    profesorDAO.insertProfesor(profesor, session);
                }

                case 3 -> {
                    //insert clasa
                    Clasa clasa = new Clasa();
                    System.out.println("Introduceti numele clasei");
                    clasa.setNumeClasa(input.next());

                    ClasaDAO clasaDAO = new ClasaDAO();
                    clasaDAO.insertClasa(clasa, session);
                }

                case 4 -> {
                    //update in functie de coloana numeElev
                    Elev elev = new Elev();
                    Clasa clasa = new Clasa();
                    System.out.println("Introduceti numele elevului pentru care doresti Update-ul");
                    String criteriuNumeElev = input.next();


                    System.out.println("Update prenumele elevului");
                    String prenumeElev = input.next();

                    System.out.println("Update varsta elevului");
                    int varsta = input.nextInt();

                    System.out.println("Update Media elevului");
                   double media = input.nextDouble();

                    elev.setNumeElev(criteriuNumeElev);
                    elev.setPrenumeElev(prenumeElev);
                    elev.setVarstaElev(varsta);
                    elev.setMedieElev(media);

                    ElevDAO elevDAO = new ElevDAO();
                    elevDAO.updateElev(elev, session);

                }
                case 5 -> {
                    // update profesor
                    Profesor profesor = new Profesor();
                    System.out.println("Introduceti numele Profesorului");
                    String numeProfesor = input.next();
                    System.out.println("Update prenumele Profesorului");
                    String prenumeProfesor = input.next();
                    System.out.println("Update Materia");
                    String materiePredata = input.next();

                    profesor.setNumeProfesor(numeProfesor);
                    profesor.setPreNumeProfesor(prenumeProfesor);
                    profesor.setMateriePredata(materiePredata);

                    ProfesorDAO profesorDAO = new ProfesorDAO();
                    profesorDAO.updateProfesorDupaNume(profesor, session);
                }

                case 6 -> {
                    //afisare toti elevii
                    System.out.println("Afisare toti elevii");
                    ElevDAO elevDAO = new ElevDAO();
                    elevDAO.afisareElev(session);
                }

                case 7 -> {
                    // afisare toate clasele
                    System.out.println("Afisare toate clasele");
                    ClasaDAO clasaDAO = new ClasaDAO();
                    clasaDAO.afisareClasa(session);
                }

                case 8 -> {
                    //afisare toti elevii care au o medie mai mare decat cea data de la tastatura
                    System.out.println("Introduceti media");
                    double medieIntrodusa = input.nextDouble();

                    ElevDAO elevDAO = new ElevDAO();
                    elevDAO.findTotiEleviCuMediaMaiMareDecat7(session, medieIntrodusa);
                }

                case 9 -> {
                    // afisare totii profesor
                    System.out.println("Afisare profesori");
                    Profesor profesor = new Profesor();
                    ProfesorDAO profesorDAO = new ProfesorDAO();
                    profesorDAO.afisareProfesor(profesor, session);
                }

                case 10 -> {
                    //asignare profesor pe clasa
                    System.out.println("Asignare profesor pe clasa:");
                    ClasaDAO clasaDAO = new ClasaDAO();
                    ProfesorDAO profesorDAO = new ProfesorDAO();

                    Clasa clasa = clasaDAO.cautareClasaDupaNume("Biologie", session);
                    Profesor profesorAsignat = profesorDAO.cautareProfesorDupaNume("Marinescu", session);

                    clasaDAO.asignareProfesorPeClasa(profesorAsignat, clasa, session);
                }

                case 11 -> {
                    //asignare elevi pe clasa
                    System.out.println("Asignare elevi pe clasa: ");
                    ElevDAO elevDAO = new ElevDAO();
                    ClasaDAO clasaDAO = new ClasaDAO();

                    Clasa clasa = clasaDAO.cautareClasaDupaNume("Biologie", session);
                    Elev elevAsignat = elevDAO.cautareElevDupaNume("Jhon", session);

                    clasaDAO.asignareElev(elevAsignat, clasa, session);
                }
                default -> System.out.println("Reia procesul");
            }
        } while (optiune != 0);
        HibernateUtil.shutdown();
    }
}
