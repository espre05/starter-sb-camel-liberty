package orca.domain.jpautil;

import java.util.stream.Stream;

public interface Encodeable {

    String token();

    public static <E extends Enum<E> & Encodeable> E forToken(Class<E> cls, String tok) {
        final String t = tok.trim().toUpperCase();
        return Stream.of(cls.getEnumConstants())
                .filter(e -> e.token().equals(t))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown token '" +
                        tok + "' for enum " + cls.getName()));
    }
}