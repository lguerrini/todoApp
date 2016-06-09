/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.todoapp.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tss
 */
public class DbService {

    private static EntityManagerFactory emf;

    private static EntityManager em;

    private DbService() {
    }

    
    static {
        emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
    }

    public static EntityManager getEm() {
        if (em != null && em.isOpen()) {
            return em;
        }

        em = emf.createEntityManager();
        return em;

    }

}
