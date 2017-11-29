package orca.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import groovy.transform.Immutable;

@Entity
@Table(name = "NOTES")
@Immutable
@IdClass(NoteId.class)
public class Note {
    @Id
    @Column(name = "ID")
    private int id;
    @Id
    @Column(name = "code")
    private Character code;
    @Id
    @Column(name = "ins_ts")
    private Timestamp insTs;
    
    
    @Column(name = "note")
    private String note;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Character getCode() {
        return code;
    }


    public void setCode(Character code) {
        this.code = code;
    }


    public Timestamp getInsTs() {
        return insTs;
    }


    public void setInsTs(Timestamp insTs) {
        this.insTs = insTs;
    }


    public String getNote() {
        return note;
    }


    public void setNote(String note) {
        this.note = note;
    }


 
    
}

class NoteId implements Serializable {
    int id;
    Character code;
    Timestamp insTs;
}
