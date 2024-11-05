package com.egg.biblioteca.util;

import com.egg.biblioteca.excepciones.MiException;

public class StringValidator {

    public static void isValid(String s) throws MiException {
        if (s.isEmpty() || s.isBlank()) {
            throw new MiException("No puede ser nulo o estar vacio");
        }
    }
}
