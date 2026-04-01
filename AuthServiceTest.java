package com.auth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {

    AuthService auth = new AuthService();

    @Test
    void testValidLogin() {
        assertTrue(auth.login("admin", "1234"));
    }

    @Test
    void testInvalidLogin() {
        assertFalse(auth.login("user", "wrong"));
    }
}
