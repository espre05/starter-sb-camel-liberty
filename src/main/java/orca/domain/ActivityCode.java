package orca.domain;
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