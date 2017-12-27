package orca.repo;

import org.springframework.data.repository.CrudRepository;

import orca.domain.InsurApplication;

public interface InsurApplicationRepository extends CrudRepository<InsurApplication, String> {
    //MunicipalCode findByPostalCode(String postalcode);
}
