package org.example.utils;

import com.github.javafaker.Faker;
import org.example.utils.components.StateAndCityComponents;

import java.time.Year;
import java.util.*;

public class TestData {
    public static Random rnd = new Random();
    public static Faker faker = new Faker();
    //генерация имени
    public static String validFirstName = faker.name().firstName();

    //генерация фамилии
    public static String validLastName = faker.name().lastName();
    //генерация email
    public static String validEmail = faker.internet().emailAddress();
    //генерация пола
    public static String gender = randomGender();
    //генерация номера
    public static String mobileNumber = randomNumber();
    //генерация дня
    public static String day = formatDay();
    //генерация месяца
    public static String month = randomMonth();
    //генерация года
    //задаем текущий год
    //передаем в метод начальный год и текущий
    public static int currentYear = Year.now().getValue();
    public static String year = String.valueOf(randomYear(1900, currentYear));
    //Вызываем метод randomSubjects для создания списка собранных предметов
    public static List<String> subjects = randomSubjects();
    //генерация хобби
    public static List<String> hobbies = randomHobbies();
    //путь к файлу
    public static String pathToPicture = "src/main/resources/sample-clouds-400x300.jpg";
    //название файла
    public static String picture = "sample-clouds-400x300.jpg";
    //генерация адреса
    public static String address = faker.address().fullAddress();
    //Помещаем ключи в список keys. Map citiesByState лежит в компонентах штат и город
    public static List<String> keys = new ArrayList<>(StateAndCityComponents.citiesByState.keySet());
    //выбор рандомного штата
    public static String state = keys.get(rnd.nextInt(keys.size()));
    //Помещаем значения в список values. Значения зависят от ключа
    public static List<String> values = StateAndCityComponents.citiesByState.get(state);
    //выбор рандомного города
    public static String city = values.get(rnd.nextInt(values.size()));
    public static String modalTextHeader = "Thanks for submitting the form";
    public static String closeText = "Close";

    /**
     * Методы для генерации значений
     */

    //собственный метод на генерацию 10 случайных чисел для мобильного номера
    public static String randomNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int a = rnd.nextInt(9);
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    //собственный метод на генерацию пола
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

    //собственный метод на генерацию случайного месяца
    public static String randomMonth() {
        var months = List.of("January", "February", "March", "April", "May", "June"
                , "June", "August", "September", "October", "November", "December");

        return months.get(rnd.nextInt(months.size()));
    }

    //Метод из интернета для генерации года. Но можно и Faker использовать как с рандомным числом
    public static int randomYear(int start, int end) {

        return start + (int) Math.round(Math.random() * (end - start));
    }

    //Свой метод. Вытаскиваем рандомное количество предметов из списка
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
}
