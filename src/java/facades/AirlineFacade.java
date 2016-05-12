/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import entity.Flight;
import security.IUserFacade;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import openshift_deploy.DeploymentConfiguration;
import security.IUser;
import security.PasswordStorage;

/**
 *
 * @author Michael
 */

public class AirlineFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);

    public AirlineFacade() {

    }

    public <T> void addEntity(T ie) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ie);
            em.getTransaction().commit();
        } catch (Exception e) {
            
        } finally {
            em.close();
        }
    }
    
    public List<Flight> getAllFlights(){
        EntityManager em = emf.createEntityManager();
        List<Flight> result = new ArrayList();
        try {
            Query q = em.createQuery("SELECT f from Flight f", Flight.class);
            result = q.getResultList();
        } finally {
            em.close();
        }
        return result;
    }

    public List<Flight> getFlightsFrom(String from, String date, int tickets) {
        EntityManager em = emf.createEntityManager();
        List<Flight> result = new ArrayList();
        try {
            Query q = em.createQuery("SELECT f FROM Flight f where f.origin=:origin AND f.date=:date AND f.numberOfSeats >:tickets", Flight.class);
            q.setParameter("origin", from);
            q.setParameter("date", date);
            q.setParameter("tickets", tickets);
            result = q.getResultList();
        } finally {
            em.close();
        }
        System.out.println("your request returned this data: " + result);
        return result;

    }
    
    public List<Flight> getFlightsFromTo(String from, String to, String date, int tickets) {
        EntityManager em = emf.createEntityManager();
        List<Flight> result = new ArrayList();
        try {
            Query q = em.createQuery("SELECT f FROM Flight f where f.origin=:origin AND f.destination=:destination AND f.date=:date AND f.numberOfSeats >:tickets", Flight.class);
            q.setParameter("origin", from);
            q.setParameter("destination", to);
            q.setParameter("date", date);
            q.setParameter("tickets", tickets);
            result = q.getResultList();
        } finally {
            em.close();
        }
        return result;

    }

}
