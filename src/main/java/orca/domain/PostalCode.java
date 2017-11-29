package orca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import groovy.transform.Immutable;

@Entity
@Table(name = "MUNICIPALITY")
@Immutable
public class PostalCode {
    @Id
    @Column(name = "POSTAL_CD")
    private  String postalCode;
    @Column(name = "MUNICIPALITY_CD")
    private  int municipalityCode;
    @Column(name = "MUNICIPALITY_DESC")
    private  String municipalityDesc;
    
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public int getMunicipalityCode() {
        return municipalityCode;
    }
    public void setMunicipalityCode(int municipalityCode) {
        this.municipalityCode = municipalityCode;
    }
    public String getMunicipalityDesc() {
        return municipalityDesc;
    }
    public void setMunicipalityDesc(String municipalityDesc) {
        this.municipalityDesc = municipalityDesc;
    }
    @Override
    public String toString() {
        return "PostalCode [postalCode=" + postalCode + ", municipalityCode=" + municipalityCode + ", municipalityDesc="
                + municipalityDesc + "]";
    }


}
