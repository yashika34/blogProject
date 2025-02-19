package com.yashika.blogapp;

import com.yashika.blogapp.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testValidPersonCreation() {
        Person person = Person.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .gender("Male")
                .build();

        assertNotNull(person);
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(25, person.getAge());
    }

    @Test
    void testInvalidPersonCreationWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            Person person = Person.builder()
                    .id(null)
                    .firstName("John")
                    .lastName("Doe")
                    .age(25)
                    .gender("Male")
                    .build();
        });
    }

    @Test
    void testInvalidPersonCreationWithNegativeAge() {
        assertThrows(IllegalArgumentException.class, () -> {
            Person person = Person.builder()
                    .id("1")
                    .firstName("John")
                    .lastName("Doe")
                    .age(-1)
                    .gender("Male")
                    .build();
        });
    }

    @Test
    void testInvalidPersonCreationWithBlankFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            Person person = Person.builder()
                    .id("1")
                    .firstName("")
                    .lastName("Doe")
                    .age(25)
                    .gender("Male")
                    .build();
        });
    }

    @Test
    void testInvalidPersonCreationWithBlankLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            Person person = Person.builder()
                    .id("1")
                    .firstName("John")
                    .lastName("")
                    .age(25)
                    .gender("Male")
                    .build();
        });
    }
}
