package org.example.utils;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class User {
    private final String validFirstName;
    private final String validLastName;
    private final String validEmail;
    private final String gender;
    private final String mobileNumber;
    private final String day;
    private final String month;
    private final String year;
    private final List<String> subjects;
    private final List<String> hobbies;
    private final String pathToPicture;
    private final String picture;
    private final String address;
    private final String state;
    private final String city;
}