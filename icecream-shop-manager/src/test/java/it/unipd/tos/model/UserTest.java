////////////////////////////////////////////////////////////////////
// Davide Sut 1201267
////////////////////////////////////////////////////////////////////


package it.unipd.tos.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User user;

    @Before
    public void setup() {
        user = new User("Davide", 21L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_constructorNullUsernameParam() {
        new User(null, 21L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_constructorZeroLengthUsernameParam() {
        new User("",21L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_constructorNonPositiveAgeParam() {
        new User("Davide", 0L);
    }

    @Test
    public void testUsernameGetter() {
        assertEquals("Davide", user.getUsername());
    }

    @Test
    public void testAgeGetter() {
        assertEquals(21L, user.getAge());
    }

}