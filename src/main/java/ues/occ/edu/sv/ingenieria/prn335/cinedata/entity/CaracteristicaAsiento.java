/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cinedata.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CF14010
 */
@Entity
@Table(name = "caracteristica_asiento", catalog = "cinev2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaracteristicaAsiento.findAll", query = "SELECT c FROM CaracteristicaAsiento c"),
    @NamedQuery(name = "CaracteristicaAsiento.findByIdCaracteristica", query = "SELECT c FROM CaracteristicaAsiento c WHERE c.idCaracteristica = :idCaracteristica"),
    @NamedQuery(name = "CaracteristicaAsiento.findByCaracteristica", query = "SELECT c FROM CaracteristicaAsiento c WHERE c.caracteristica = :caracteristica"),
    @NamedQuery(name = "CaracteristicaAsiento.findByDescripcion", query = "SELECT c FROM CaracteristicaAsiento c WHERE c.descripcion = :descripcion")})
public class CaracteristicaAsiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_caracteristica")
    private Integer idCaracteristica;
    @Basic(optional = false)
    @Column(name = "caracteristica")
    private String caracteristica;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caracteristicaAsiento")
    private List<AtributoAsiento> atributoAsientoList;

    public CaracteristicaAsiento() {
    }

    public CaracteristicaAsiento(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public CaracteristicaAsiento(Integer idCaracteristica, String caracteristica, String descripcion) {
        this.idCaracteristica = idCaracteristica;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public Integer getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<AtributoAsiento> getAtributoAsientoList() {
        return atributoAsientoList;
    }

    public void setAtributoAsientoList(List<AtributoAsiento> atributoAsientoList) {
        this.atributoAsientoList = atributoAsientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaracteristica != null ? idCaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaracteristicaAsiento)) {
            return false;
        }
        CaracteristicaAsiento other = (CaracteristicaAsiento) object;
        if ((this.idCaracteristica == null && other.idCaracteristica != null) || (this.idCaracteristica != null && !this.idCaracteristica.equals(other.idCaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.cinedata.entity.CaracteristicaAsiento[ idCaracteristica=" + idCaracteristica + " ]";
    }
    
}
