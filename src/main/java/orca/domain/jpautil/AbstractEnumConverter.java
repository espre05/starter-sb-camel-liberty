package orca.domain.jpautil;

import javax.persistence.AttributeConverter;

public abstract class AbstractEnumConverter<E extends Enum<E> & Encodeable>
            implements AttributeConverter<E, String> {

    public String toDatabaseColumn(E attr) {
        return (attr == null)
                ? null
                : attr.token();
    }

    public E toEntityAttribute(Class<E> cls, String dbCol) {
        return (dbCol == null)
                ? null
                : Encodeable.forToken(cls, dbCol);
    }
}