package orca.repo;

import orca.domain.MunicipalCode;

public interface MunicipalCodeRepository extends ReadOnlyRepository<MunicipalCode, String> {
    //MunicipalCode findByPostalCode(String postalcode);
}
