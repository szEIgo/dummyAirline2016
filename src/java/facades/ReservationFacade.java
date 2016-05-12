///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
//import entity.Flight;
//import entity.ReservationRequestEntity;
//import entity.ReservationResponseEntity;
//import java.util.ArrayList;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//import openshift_deploy.DeploymentConfiguration;
//
///**
// *
// * @author michael
// */
//public class ReservationFacade {
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
//
//    public ReservationFacade() {
//
//    }
//
//    public <T> void addEntity(T ie) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.persist(ie);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            
//        } finally {
//            em.close();
//        }
//    }
//
//    public ReservationResponseEntity MakeReservation(ReservationRequestEntity request) throws Exception {
//        EntityManager em = emf.createEntityManager();
//        boolean stillAvailable = false;
//        ReservationResponseEntity result = new
//        Flight desired;
//        try {
//            desired = em.find(Flight.class, request.getFlightId());
//            if (desired.getNumberOfSeats()>request.getNumberOfSeats()){
//                desired.setNumberOfSeats(desired.getNumberOfSeats()-request.getNumberOfSeats());
//                em.merge(desired);
//                stillAvailable = true;
//                
//            }
//        } finally {
//            em.close();
//        }
//        System.out.println("your request returned this data: " + desired);
//        
//        if (stillAvailable){
//            
//            
//            return desired;
//        }
//        else{
//            throw new Exception("there are only " + desired.getNumberOfSeats() + " seats left on this flight");
//        }
//    }
//}
