package com.decroly.demo;

public class GmailValidator {

    public static boolean isValidGmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        email = email.trim().toLowerCase();

        return email.endsWith("@gmail.com") && email.length() > 10;
    }
}