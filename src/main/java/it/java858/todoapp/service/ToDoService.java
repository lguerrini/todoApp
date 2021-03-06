/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.todoapp.service;

import it.java858.todoapp.entity.Categoria;
import it.java858.todoapp.entity.ToDo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tss
 */
public class ToDoService {

    private ToDoService() {
    }

    public static ToDo save(ToDo toSave) {
        EntityManager em = DbService.getEm();
        em.getTransaction().begin();
        ToDo saved = em.merge(toSave);
        em.getTransaction().commit();
        return saved;
    }

    public static List<ToDo> findByCategoria(Categoria c){
        EntityManager em = DbService.getEm();
        return em.createQuery("select e from ToDo e where :p MEMBER OF e.categorie", ToDo.class)
                .setParameter("p", c)
                .getResultList();
    }
    
    public static void delete(ToDo todo){
        EntityManager em = DbService.getEm();
        em.getTransaction().begin();
        em.remove(todo);
        em.getTransaction().commit();
    }
}
