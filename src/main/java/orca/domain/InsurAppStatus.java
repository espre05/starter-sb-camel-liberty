package orca.domain;

import orca.domain.jpautil.Encodeable;

public enum InsurAppStatus implements Encodeable{
INITIAL("INITIAL")
,ONHOLD("ONHOLD")
,COMMITTED("COMMITTED")
,REJECTED("REJECTED");

    final String e_token;

    InsurAppStatus(String v) {
        this.e_token = v;
    }

    @Override
    public String token() {
        return this.e_token;
    }
}
