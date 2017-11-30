package orca.domain.jpautil;

import javax.persistence.Converter;

import orca.domain.InsurAppStatus;

@Converter
public class InsurAppStatusConverter 
            extends AbstractEnumConverter<InsurAppStatus> {

    @Override
    public String convertToDatabaseColumn(InsurAppStatus attribute) {
        return this.toDatabaseColumn(attribute);
    }

    @Override
    public InsurAppStatus convertToEntityAttribute(String dbData) {
        return this.toEntityAttribute(InsurAppStatus.class, dbData);
    }
}