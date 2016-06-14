/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.todoapp;

import it.java858.todoapp.gui.Main;
import it.java858.todoapp.service.DbService;
import javax.persistence.EntityManager;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
             
        EntityManager em = DbService.getEm();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
                
    }
}
