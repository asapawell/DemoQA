package Pages.testData;

import com.github.javafaker.Faker;

import java.time.Year;
import java.util.List;
import java.util.Random;

public class TestData {
    static Faker faker = new Faker();
    //генерация имени
    public static String validFirstName = faker.name().firstName();
    //генерация фамилии
    public static String validLastName = faker.name().lastName();
    //генерация email
    public static String validEmail = faker.internet().emailAddress();
    //генерация пола
    public static String gender = randomGender();
    //мобильный номер
    public static String mobileNumber = randomNumber();

    //Задаем метод formatDay. Передаем numberBetween числа от 1 до 28 (чтоб февраль не ломался и месяца, где по 30 дней,
    //а то писать долго придется.)
    //Возвращаем условие: если сгенерированное число меньше 10, то добавляем 0 спереди
    //Это требуется для локатора дня
    public static String formatDay() {
        int day = faker.number().numberBetween(1, 28);
        return (day < 10) ? "0" + day : String.valueOf(day);
    }

    public static String day = formatDay();
    //рандомный месяц
    public static String month = randomMonth();
    //задаем текущий год
    //передаем в метод начальный год и текущий
    static int currentYear = Year.now().getValue();
    public static String year = String.valueOf(randomYear(1900, currentYear));
    public static String address = faker.address().fullAddress();

    //собственный метод на генерацию 10 случайных чисел для мобильного номера
    public static String randomNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int a = rnd.nextInt(9);
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    //собственный метод на генерацию пола
    public static String randomGender() {
        Random rnd = new Random();
        var genders = List.of("Male", "Female", "Other");
        return genders.get(rnd.nextInt(2));
    }

    //собственный метод на генерацию случайного месяца
    public static String randomMonth() {
        Random rnd = new Random();
        var months = List.of("January", "February", "March", "April", "May", "June"
                , "June", "August", "September", "October", "November", "December");

        return months.get(rnd.nextInt(11));
    }

    //Метод из интернета для генерации года. Но можно и Faker использовать как с рандомным числом
    public static int randomYear(int start, int end) {

        return start + (int) Math.round(Math.random() * (end - start));
    }

}
