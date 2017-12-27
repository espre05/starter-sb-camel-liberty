package orca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "INSUR_APPLICATIONS")
@Data
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
  }
