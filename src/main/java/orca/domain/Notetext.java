package orca.domain;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Entity
@Table(name = "NOTETEXT")
@Immutable
@IdClass(NotetextId.class)
@Data
public class Notetext {
    @Id
    @Column(name = "ID")
    private  String id;
    @Id
    @Column(name = "code1")
    private  String code1;
    @Id
    @Column(name = "code2")
    private  String code2;   
    @Id
    @Column(name = "note")
    private  String note; 
    @Id
    @Column(name = "code3")
    private  String code3; 
    @Id
    @Column(name = "dt")
    private  Date date; 
    @Id
    @Column(name = "ins_ts", nullable = true)
    private  Timestamp insts; 

    @Column(name = "ins_userid", nullable = true)
    private  String insUser; 
    
    @Column(name = "upd_ts", nullable = true)
    private  Timestamp updts; 

    @Column(name = "upd_userid", nullable = true)
    private  String updUser;     
    
    @Column(name = "dt_valid_from")
    private  Date dateValidFrom; 
    
    @Column(name = "dt_valid_to")
    private  Date dateValidTo;  
}

class NotetextId implements Serializable{
    String id;
    String code1;
    String code2;   
    String note; 
    String code3; 
    Date date; 
    Timestamp insts; 
}
