package com.pluralsight;

public class NameFormatter {

    //private constructor to prevent instantiation
    private NameFormatter() {
        throw new UnsupportedOperationException("Utility class");
    }

    //format for first and last name only
    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    // format with all components
    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        StringBuilder formatted = new StringBuilder();
        formatted.append(lastName).append(", ");

        if (prefix != null && !prefix.isEmpty()) {
            formatted.append(prefix).append(" ");
        }

        formatted.append(firstName);

        if (middleName != null && !middleName.isEmpty()) {
            formatted.append(" ").append(middleName);
        }

        if (suffix != null && !suffix.isEmpty()) {
            formatted.append(", ").append(suffix);
        }

        return formatted.toString();
    }

    // parse fullName and format it
    public static String format(String fullName) {
        //abbreviate suffix if needed
        String suffix = "";
        if (fullName.contains(",")) {
            String[] parts = fullName.split(",", 2);
            fullName = parts[0].trim();
            suffix = parts[1].trim();
        }

        String[] nameParts = fullName.trim().split("\\s+");
        String prefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";

        int index = 0;

        if (nameParts[0].endsWith(".")) {
            prefix = nameParts[index++];
        }

        if (index < nameParts.length) {
            firstName = nameParts[index++];
        }

        if (index < nameParts.length - 1) {
            middleName = nameParts[index++];
        }

        if (index < nameParts.length) {
            lastName = nameParts[index];
        }

        return format(prefix, firstName, middleName, lastName, suffix);
    }
}
