package org.example.utils;

import com.github.javafaker.Faker;

import java.time.Year;
import java.util.*;

public class TestData {
    /**
     * Методы для генерации значений
     */
    public static Random rnd = new Random();
    public static Faker faker = new Faker();

    //генерация мобильного номера
    public static String randomNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int a = rnd.nextInt(9);
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    //генерация пола
    public static String randomGender() {
        var genders = List.of("Male", "Female", "Other");
        return genders.get(rnd.nextInt(2));
    }

    //Задаем метод formatDay. Передаем numberBetween числа от 1 до 28 (чтоб февраль не ломался и месяца, где по 30 дней,
    //а то писать долго придется.)
    //Возвращаем условие: если сгенерированное число меньше 10, то добавляем 0 спереди
    //Это требуется для локатора дня
    public static String formatDay() {
        int day = faker.number().numberBetween(1, 28);
        return (day < 10) ? "0" + day : String.valueOf(day);
    }

    //случайный месяц
    public static String randomMonth() {
        var months = List.of("January", "February", "March", "April", "May", "June"
                , "June", "August", "September", "October", "November", "December");

        return months.get(rnd.nextInt(months.size()));
    }

    //задаем текущий год
    public static int currentYear = Year.now().getValue();

    //Генерация года. Но можно и Faker использовать как с рандомным числом
    public static int randomYear(int start, int end) {

        return start + (int) Math.round(Math.random() * (end - start));
    }

    //Вытаскиваем рандомное количество предметов из списка
    //их может быть передано от 1 до 6
    public static List<String> randomSubjects() {
        Random rnd = new Random();
        List<String> subjects = new ArrayList<>();
        Collections.addAll(subjects, "Chemistry", "English", "Economics", "Maths", "Biology", "Civics",
                "Computer Science", "Hindi", "Arts");
        Collections.shuffle(subjects);
        int numValues = rnd.nextInt(1, 6);
        return subjects.stream()
                .limit(numValues)
                .toList();
    }

    public static List<String> randomHobbies() {
        Random rnd = new Random();
        List<String> hobbies = new ArrayList<>();
        Collections.addAll(hobbies, "Sports", "Reading", "Music");
        Collections.shuffle(hobbies);
        return hobbies.stream()
                .limit(rnd.nextInt(1, hobbies.size()))
                .toList();
    }

    //Выберем рандомный город из штата NCR
    public static String randomCity() {
        var cities = List.of("Delhi", "Gurgaon", "Noida");
        return cities.get(rnd.nextInt(cities.size()));
    }
}
