/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Faby
 */
@Embeddable
public class EntregasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta")
    private int venta;

    public EntregasPK() {
    }

    public EntregasPK(int id, int venta) {
        this.id = id;
        this.venta = venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) venta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntregasPK)) {
            return false;
        }
        EntregasPK other = (EntregasPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.venta != other.venta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.EntregasPK[ id=" + id + ", venta=" + venta + " ]";
    }
    
}
