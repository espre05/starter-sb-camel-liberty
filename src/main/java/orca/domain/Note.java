package telus.hns.bpcs.integration.domain;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "NOTETEXT")
@Immutable
@IdClass(NotetextId.class)
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getInsts() {
		return insts;
	}

	public void setInsts(Timestamp insts) {
		this.insts = insts;
	}

	public String getInsUser() {
		return insUser;
	}

	public void setInsUser(String insUser) {
		this.insUser = insUser;
	}

	public Timestamp getUpdts() {
		return updts;
	}

	public void setUpdts(Timestamp updts) {
		this.updts = updts;
	}

	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public Date getDateValidFrom() {
		return dateValidFrom;
	}

	public void setDateValidFrom(Date dateValidFrom) {
		this.dateValidFrom = dateValidFrom;
	}

	public Date getDateValidTo() {
		return dateValidTo;
	}

	public void setDateValidTo(Date dateValidTo) {
		this.dateValidTo = dateValidTo;
	}

	@Override
	public String toString() {
		return "Notetext [id=" + id + ", code1=" + code1 + ", code2=" + code2 + ", note=" + note + ", code3=" + code3
				+ ", date=" + date + ", insts=" + insts + ", insUser=" + insUser + ", updts=" + updts + ", updUser="
				+ updUser + ", dateValidFrom=" + dateValidFrom + ", dateValidTo=" + dateValidTo + "]";
	} 
    
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


package telus.hns.bpcs.integration.domain;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "TRACTIVITY")
@Immutable
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode1() {
		return code1;
	}
	public void setCode1(int code1) {
		this.code1 = code1;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getInsUser() {
		return insUser;
	}
	public void setInsUser(String insUser) {
		this.insUser = insUser;
	}
	public Timestamp getInsts() {
		return insts;
	}
	public void setInsts(Timestamp insts) {
		this.insts = insts;
	}
	public String getUpdUser() {
		return updUser;
	}
	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}
	public Timestamp getUpdts() {
		return updts;
	}
	public void setUpdts(Timestamp updts) {
		this.updts = updts;
	}
	@Override
	public String toString() {
		return "ActivityCode [id=" + id + ", code1=" + code1 + ", msg=" + msg + ", date=" + date + ", insUser="
				+ insUser + ", insts=" + insts + ", updUser=" + updUser + ", updts=" + updts + "]";
	} 
   

}
