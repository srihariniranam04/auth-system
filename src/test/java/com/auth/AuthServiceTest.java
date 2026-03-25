package com.auth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {

    AuthService auth = new AuthService();

    @Test
    void testValidLogin() {
        assertTrue(auth.login("admin", "Admin@123"));
    }

    @Test
    void testInvalidPasswordFormat() {
        assertFalse(auth.login("admin", "admin"));
    }

    @Test
    void testWrongCredentials() {
        assertFalse(auth.login("admin", "Wrong@123"));
    }

    @Test
    void testAccountLockAfterThreeAttempts() {

        auth.login("admin", "Wrong@123");
        auth.login("admin", "Wrong@123");
        auth.login("admin", "Wrong@123");

        assertTrue(auth.isAccountLocked());
    }
}
