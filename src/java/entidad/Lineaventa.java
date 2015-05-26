/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Faby
 */
@Entity
@Table(name = "lineaventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineaventa.findAll", query = "SELECT l FROM Lineaventa l"),
    @NamedQuery(name = "Lineaventa.findById", query = "SELECT l FROM Lineaventa l WHERE l.id = :id"),
    @NamedQuery(name = "Lineaventa.findByCantidad", query = "SELECT l FROM Lineaventa l WHERE l.cantidad = :cantidad")})
public class Lineaventa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "maquinaria", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Maquinaria maquinaria;
    @JoinColumn(name = "venta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Venta venta;

    public Lineaventa() {
    }

    public Lineaventa(Integer id) {
        this.id = id;
    }

    public Lineaventa(Integer id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Maquinaria getMaquinaria() {
        return maquinaria;
    }

    public void setMaquinaria(Maquinaria maquinaria) {
        this.maquinaria = maquinaria;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineaventa)) {
            return false;
        }
        Lineaventa other = (Lineaventa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Lineaventa[ id=" + id + " ]";
    }
    
}
