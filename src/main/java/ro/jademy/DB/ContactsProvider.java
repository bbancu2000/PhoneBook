package ro.jademy.DB;

import com.github.javafaker.Faker;
import ro.jademy.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactsProvider {
    Faker faker = new Faker();

    public static List<Contact> getContacts() {
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Gigi", "Gigescu", "0784783333", ""));
        contactList.add(new Contact("Gigel", "Gigescu", "0784783333", ""));
        contactList.add(new Contact("Gigi", "Ionescu", "0784783333", ""));
        contactList.add(new Contact("Gigel", "Ionescu", "0784783333", ""));
        contactList.add(new Contact("Daniel", "Modoran", "", ""));
        contactList.add(new Contact("Lampagiu", "Bertone", "0784784444", ""));


        Collections.sort(contactList);
        return contactList;
    }


}
