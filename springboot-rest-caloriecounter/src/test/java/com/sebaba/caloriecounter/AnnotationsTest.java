package com.sebaba.caloriecounter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.annotation.Annotation;

import org.junit.jupiter.api.Test;

import com.sebaba.caloriecounter.core.validation.NamingConstraintValidator;
import com.sebaba.caloriecounter.core.validation.NamingValidation;

import jakarta.validation.Payload;

class AnnotationsTest {

	@Test
    public void testValidName() {
        NamingConstraintValidator validator = new NamingConstraintValidator();
        validator.initialize(createNamingValidation(1, 10));
        assertTrue(validator.isValid("validName", null));
    }

    @Test
    public void testNullName() {
        NamingConstraintValidator validator = new NamingConstraintValidator();
        validator.initialize(createNamingValidation(1, 10));
        assertFalse(validator.isValid(null, null));
    }

    @Test
    public void testEmptyName() {
        NamingConstraintValidator validator = new NamingConstraintValidator();
        validator.initialize(createNamingValidation(1, 10));
        assertFalse(validator.isValid("", null));
    }

    @Test
    public void testTrimmedName() {
        NamingConstraintValidator validator = new NamingConstraintValidator();
        validator.initialize(createNamingValidation(2, 20));
        assertFalse(validator.isValid("  S ", null));
    }
    
    @Test
    public void testInsideWhitespacesName() {
        NamingConstraintValidator validator = new NamingConstraintValidator();
        validator.initialize(createNamingValidation(2, 20));
        assertFalse(validator.isValid("a      b", null));
    }
    
    @Test
    public void testShortName() {
        NamingConstraintValidator validator = new NamingConstraintValidator();
        validator.initialize(createNamingValidation(5, 10));
        assertFalse(validator.isValid("shor", null));
    }

    @Test
    public void testLongName() {
        NamingConstraintValidator validator = new NamingConstraintValidator();
        validator.initialize(createNamingValidation(1, 5));
        assertFalse(validator.isValid("thisIsAReallyLongName", null));
    }

    @Test
    public void testNameWithForbiddenCharacters() {
        NamingConstraintValidator validator = new NamingConstraintValidator();
        validator.initialize(createNamingValidation(1, 30));
        assertFalse(validator.isValid("name with <special>", null));
    }

    @Test
    public void testNameWithAcceptedCharacters() {
        NamingConstraintValidator validator = new NamingConstraintValidator();
        validator.initialize(createNamingValidation(1, 30));
        assertTrue(validator.isValid("name_special_characters", null));
    }
    
    // Helper method to create a NamingValidation annotation
    private NamingValidation createNamingValidation(int minLength, int maxLength) {
        return new NamingValidation() {
            @Override
            public String message() {
                return "invalid naming";
            }

            @Override
            public Class<?>[] groups() {
                return new Class<?>[0];
            }

            @SuppressWarnings("unchecked")
			@Override
            public Class<? extends Payload>[] payload() {
                return new Class[0];
            }

            @Override
            public int minLength() {
                return minLength;
            }

            @Override
            public int maxLength() {
                return maxLength;
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return NamingValidation.class;
            }
        };
    }

}