package tests;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String randomTaskTitle = faker.ancient().god();
    public String randomTaskDescription = faker.lordOfTheRings().location();
    public String randomNoteTitle = faker.harryPotter().house();
}
