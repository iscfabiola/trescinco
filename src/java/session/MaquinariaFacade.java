/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entidad.Maquinaria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Faby
 */
@Stateless
public class MaquinariaFacade extends AbstractFacade<Maquinaria> {
    @PersistenceContext(unitName = "trescincoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaquinariaFacade() {
        super(Maquinaria.class);
    }
    
}
