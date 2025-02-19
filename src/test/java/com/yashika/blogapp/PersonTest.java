@Test
public void testInvalidPerson() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Person(null, "John", "Doe", 30, "Male");
    });
    assertThrows(IllegalArgumentException.class, () -> {
        new Person("1", null, "Doe", 30, "Male");
    });
}
