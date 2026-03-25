package com.auth;

public class AuthService {

    private int failedAttempts = 0;
    private boolean accountLocked = false;

    private final String USERNAME = "admin";
    private final String PASSWORD = "Admin@123";

    public boolean login(String username, String password) {

        if (accountLocked) {
            System.out.println("Account is locked!");
            return false;
        }

        if (!isValidPasswordFormat(password)) {
            System.out.println("Invalid password format!");
            return false;
        }

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            failedAttempts = 0;
            return true;
        } else {

            failedAttempts++;

            if (failedAttempts >= 3) {
                accountLocked = true;
                System.out.println("Account locked after 3 failed attempts!");
            }

            return false;
        }
    }

    private boolean isValidPasswordFormat(String password) {

        if (password.length() < 8)
            return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch))
                hasUpper = true;

            else if (Character.isLowerCase(ch))
                hasLower = true;

            else if (Character.isDigit(ch))
                hasDigit = true;

            else
                hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }
}
