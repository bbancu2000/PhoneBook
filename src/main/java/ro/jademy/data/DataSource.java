package ro.jademy.data;

import com.github.javafaker.Faker;
import ro.jademy.model.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSource {
    private static final Faker faker = new Faker();

    public static List<Contact> getContactList() {
        List<Contact> contactList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            contactList.add(new Contact(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.phoneNumber().phoneNumber(),
                    faker.phoneNumber().phoneNumber(),
                    faker.internet().emailAddress()));
        }

//        contactList.add(new Contact("Gigi", "Gigescu", "0754444425", "1234567890", "email@email.com"));
//        contactList.add(new Contact("Gigi", "Gigescu", "0744444425", "12212130", "alina@email.com"));
//        contactList.add(new Contact("Maria", "Gigescu", "0744444425", "123490", "gigi@email.com"));
//        contactList.add(new Contact("Gigi", "Gigescu", "0744444425", "32334567890", "mihai@email.com"));
//        contactList.add(new Contact("Alina", "Alina", "074412132", "12332390", "ion@email.com"));
//        contactList.add(new Contact("Ioana", "Gigescu", "074442135", "4567890", "mail@email.com"));
//        contactList.add(new Contact("Ion", "Ionescu", "07442124212", "123890", "eil@email.com"));
//        contactList.add(new Contact("Gigi", "Gigescu", "0784783333"));
//        contactList.add(new Contact("Gigel", "Gigescu", "0784783333"));
//        contactList.add(new Contact("Gigi", "Ionescu", "0784783333"));
//        contactList.add(new Contact("Gigel", "Ionescu", "0784783333"));
//        contactList.add(new Contact("Daniel", "Modoran", "698"));
//        contactList.add(new Contact("Lampagiu", "Bertone", "0784784444"));

        Collections.sort(contactList);
        return contactList;

    }
}