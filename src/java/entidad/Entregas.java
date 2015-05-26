/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Faby
 */
@Entity
@Table(name = "entregas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregas.findAll", query = "SELECT e FROM Entregas e"),
    @NamedQuery(name = "Entregas.findById", query = "SELECT e FROM Entregas e WHERE e.entregasPK.id = :id"),
    @NamedQuery(name = "Entregas.findByVenta", query = "SELECT e FROM Entregas e WHERE e.entregasPK.venta = :venta"),
    @NamedQuery(name = "Entregas.findByFechareal", query = "SELECT e FROM Entregas e WHERE e.fechareal = :fechareal")})
public class Entregas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntregasPK entregasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechareal")
    @Temporal(TemporalType.DATE)
    private Date fechareal;
    @JoinColumn(name = "camion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Camion camion;
    @JoinColumn(name = "venta", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta1;

    public Entregas() {
    }

    public Entregas(EntregasPK entregasPK) {
        this.entregasPK = entregasPK;
    }

    public Entregas(EntregasPK entregasPK, Date fechareal) {
        this.entregasPK = entregasPK;
        this.fechareal = fechareal;
    }

    public Entregas(int id, int venta) {
        this.entregasPK = new EntregasPK(id, venta);
    }

    public EntregasPK getEntregasPK() {
        return entregasPK;
    }

    public void setEntregasPK(EntregasPK entregasPK) {
        this.entregasPK = entregasPK;
    }

    public Date getFechareal() {
        return fechareal;
    }

    public void setFechareal(Date fechareal) {
        this.fechareal = fechareal;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public Venta getVenta1() {
        return venta1;
    }

    public void setVenta1(Venta venta1) {
        this.venta1 = venta1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entregasPK != null ? entregasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregas)) {
            return false;
        }
        Entregas other = (Entregas) object;
        if ((this.entregasPK == null && other.entregasPK != null) || (this.entregasPK != null && !this.entregasPK.equals(other.entregasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Entregas[ entregasPK=" + entregasPK + " ]";
    }
    
}
