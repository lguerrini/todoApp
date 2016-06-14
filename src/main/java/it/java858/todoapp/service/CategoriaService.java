/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.todoapp.service;

import it.java858.todoapp.entity.Categoria;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author alfonso
 */
public class CategoriaService {

    public static void elimina(Categoria c) {
        EntityManager em = DbService.getEm();
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    private CategoriaService() {
    }

    public static Categoria save(Categoria c) {
        EntityManager em = DbService.getEm();
        em.getTransaction().begin();
        Categoria saved = em.merge(c);
        em.getTransaction().commit();
        return saved;
    }

    public static List<Categoria> findAll() {
        EntityManager em = DbService.getEm();
        return em.createQuery("select e from Categoria e order by e.nome", Categoria.class)
                .getResultList();
    }
}
