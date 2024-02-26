package org.example.utils;

import com.github.javafaker.Faker;

import static org.example.utils.TestData.*;

public class UserBuilder {
    public static Faker faker = new Faker();
    public static User user = User.builder()
            .validFirstName(faker.name().firstName())
            .validLastName(faker.name().lastName())
            .validEmail(faker.internet().emailAddress())
            .gender(randomGender())
            .mobileNumber(randomNumber())
            .day(formatDay())
            .month(randomMonth())
            .year(String.valueOf(randomYear(1900, currentYear)))
            .subjects(randomSubjects())
            .hobbies(randomHobbies())
            .pathToPicture("src/main/resources/sample-clouds-400x300.jpg")
            .picture("sample-clouds-400x300.jpg")
            .address(faker.address().fullAddress())
            .state("NCR")
            .city(randomCity())
            .build();
}