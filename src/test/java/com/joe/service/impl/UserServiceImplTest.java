package com.joe.service.impl;

import com.joe.entity.User;
import com.joe.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private IUserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    void checkUser_withCorrectCredentials_returnsTrue() {
        assertTrue(userService.checkUser("joe", "joe123"));
    }

    @Test
    void checkUser_withWrongPassword_returnsFalse() {
        assertFalse(userService.checkUser("joe", "wrongpassword"));
    }

    @Test
    void checkUser_withNonExistentUser_returnsFalse() {
        assertFalse(userService.checkUser("nonexistent", "anypassword"));
    }

    @Test
    void checkUser_withNullLoginName_returnsFalse() {
        assertFalse(userService.checkUser(null, "anypassword"));
    }

    @Test
    void checkUser_withEmptyLoginName_returnsFalse() {
        assertFalse(userService.checkUser("", "anypassword"));
    }

    @Test
    void checkUser_withNullPassword_returnsFalse() {
        assertFalse(userService.checkUser("joe", null));
    }

    @Test
    void checkUser_withEmptyPassword_returnsFalse() {
        assertFalse(userService.checkUser("joe", ""));
    }

    @Test
    void getUserByLoginName_withExistingUser_returnsUser() {
        User user = userService.getUserByLoginName("joe");
        assertNotNull(user);
        assertEquals("2019", user.getId());
        assertEquals("joe", user.getName());
        assertEquals(18, user.getAge());
    }

    @Test
    void getUserByLoginName_withNonExistentUser_returnsNull() {
        assertNull(userService.getUserByLoginName("nonexistent"));
    }
}
