package orca.domain;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TRACTIVITY")
//@Immutable
@Data
public class ActivityCode {
    @Id
    @Column(name = "id")
    private  int id;
    @Column(name = "code1")
    private  int code1;
    @Column(name = "msg")
    private  String msg;
    
    @Column(name = "dt")
    private  Date date; 
    
    @Column(name = "ins_userid", nullable = true)
    private  String insUser; 
    @Column(name = "ins_ts", nullable = true)
    private  Timestamp insts; 
    
    @Column(name = "upd_userid", nullable = true)
    private  String updUser;  
    @Column(name = "upd_ts", nullable = true)
    private  Timestamp updts;
}