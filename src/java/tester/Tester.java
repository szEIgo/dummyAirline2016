/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Flight;
import facades.AirlineFacade;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Eske Wolff
 */
public class Tester {
    
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory(openshift_deploy.DeploymentConfiguration.PU_NAME).createEntityManager();
        AirlineFacade af = new AirlineFacade();
        
        System.out.println("Some result: "+ em.find(Flight.class, "0001-2566019705785"));
//        System.out.println(af.getFlightsFrom("CDG", "2016-01-26T13:00:00.000Z", 2));
    }
    
}
