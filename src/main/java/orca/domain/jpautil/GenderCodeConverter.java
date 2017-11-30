package orca.domain.jpautil;

import javax.persistence.Converter;

import orca.domain.GenderCode;

@Converter
public class GenderCodeConverter 
            extends AbstractEnumConverter<GenderCode> {

    @Override
    public String convertToDatabaseColumn(GenderCode attribute) {
        return this.toDatabaseColumn(attribute);
    }

    @Override
    public GenderCode convertToEntityAttribute(String dbData) {
        return this.toEntityAttribute(GenderCode.class, dbData);
    }
}