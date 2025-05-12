package com.pluralsight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NameFormatterTest {

    @Test
    public void testFirstAndLastName() {
        String result = NameFormatter.format("Mel", "Johnson");
        assertEquals("Johnson, Mel", result);
    }

    @Test
    public void testFullFormatWithAllFields() {
        String result = NameFormatter.format("Dr.", "Mel", "B", "Johnson", "PhD");
        assertEquals("Johnson, Dr. Mel B, PhD", result);
    }

    @Test
    public void testFullNameWithPrefixMiddleAndSuffix() {
        String result = NameFormatter.format("Dr. Mel B Johnson, PhD");
        assertEquals("Johnson, Dr. Mel B, PhD", result);
    }

    @Test
    public void testFullNameWithMiddleAndSuffix() {
        String result = NameFormatter.format("Mel B Johnson, PhD");
        assertEquals("Johnson, Mel B, PhD", result);
    }

    @Test
    public void testFullNameWithFirstAndLastOnly() {
        String result = NameFormatter.format("Mel Johnson");
        assertEquals("Johnson, Mel", result);
    }

    @Test
    public void testFullFormatWithMissingOptionalParts() {
        String result = NameFormatter.format("", "Mel", "", "Johnson", "");
        assertEquals("Johnson, Mel", result);
    }
}
