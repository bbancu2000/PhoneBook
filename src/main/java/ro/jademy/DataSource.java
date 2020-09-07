package ro.jademy;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static final Faker faker = new Faker();

    public static List<Contact> getContactList() {
        List<Contact> contactList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            contactList.add(new Contact(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.phoneNumber().phoneNumber(),
                    faker.phoneNumber().phoneNumber(),
                    faker.internet().emailAddress()));
        }

        return contactList;

    }
}





