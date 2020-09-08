package ro.jademy.service;

import ro.jademy.model.Contact;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    public List<Contact> searchContactByFirstName(List<Contact> contactList, String firstName) {

        return contactList.stream()
                .filter(contact -> contact.getFirstName().toLowerCase().contains(firstName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Contact> searchContactByLastName(List<Contact> contactList, String lastName) {

        return contactList.stream()
                .filter(contact -> contact.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Contact> searchContactByPhoneNumber(List<Contact> contactList, String phoneNumber) {

        return contactList.stream()
                .filter(contact -> contact.getPhoneNumber() != null && contact.getSecondPhoneNumber() != null)
                .filter(contact -> contact.getPhoneNumber().contains(phoneNumber) || contact.getSecondPhoneNumber().contains(phoneNumber))
                .collect(Collectors.toList());
    }

    public List<Contact> searchContactByEmail(List<Contact> contactList, String email) {

        return contactList.stream()
                .filter(contact -> contact.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());
    }
}