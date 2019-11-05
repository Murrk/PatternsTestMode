package ru.netology.testMode;

import com.github.javafaker.Faker;
import java.util.Locale;

public class AuthInfo {
    private AuthInfo() {
    }

    public static User AuthInfoActive() {

        Faker faker = new Faker(new Locale("En"));

        return new User(
                faker.name().firstName(),
                faker.lorem().characters(8, 16),
                getSatusActive()
        );
    }

    public static User AuthInfoBloked() {

        Faker faker = new Faker(new Locale("En"));

        return new User(
                faker.name().firstName(),
                faker.lorem().characters(8, 16),
                getSatusBloked()
        );
    }

    public static String getSatusBloked() {
        return "blocked";
    }

    public static String getSatusActive() {
        return "active";
    }
}

