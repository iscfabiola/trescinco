/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entidad.Lineaventa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Faby
 */
@Stateless
public class LineaventaFacade extends AbstractFacade<Lineaventa> {
    @PersistenceContext(unitName = "trescincoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineaventaFacade() {
        super(Lineaventa.class);
    }
    
}
