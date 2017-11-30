package orca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "INSUR_APPLICATIONS")
public class InsurApplication {
    @Id
    @Column(name = "APP_NUM")
    String appNumber;
    @Column(name = "name")
    String name;
    
    @Enumerated
    @Column(name = "gender",columnDefinition = "char")
    GenderCode gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "APP_STATUS",length = 10)
    InsurAppStatus status;
    
    public String getAppNumber() {
        return appNumber;
    }
    public void setAppNumber(String appNumber) {
        this.appNumber = appNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public InsurAppStatus getStatus() {
        return status;
    }
    public void setStatus(InsurAppStatus status) {
        this.status = status;
    }
    
    public GenderCode getGender() {
        return gender;
    }
    public void setGender(GenderCode gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "InsurApplication [appNumber=" + appNumber + ", name=" + name + ", gender=" + gender + ", status="
                + status + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((appNumber == null) ? 0 : appNumber.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InsurApplication other = (InsurApplication) obj;
        if (appNumber == null) {
            if (other.appNumber != null)
                return false;
        } else if (!appNumber.equals(other.appNumber))
            return false;
        if (gender != other.gender)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (status != other.status)
            return false;
        return true;
    }
    
 
}
