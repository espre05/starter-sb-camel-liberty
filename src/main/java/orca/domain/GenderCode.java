package orca.domain;

import orca.domain.jpautil.Encodeable;

public enum GenderCode implements Encodeable {

    MALE   ("M"), 
    FEMALE ("F"), 
    OTHER  ("O");

    final String e_token;

    GenderCode(String v) {
        this.e_token = v;
    }

    @Override
    public String token() {
        return this.e_token;
    }
}