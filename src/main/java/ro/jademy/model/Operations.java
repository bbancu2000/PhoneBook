package ro.jademy.model;

import java.util.List;
import java.util.Scanner;

public class Operations {
    static Scanner scanner = new Scanner(System.in);

    public static void displayContacts(List<Contact> contactList) {
        if (contactList.isEmpty()) {
            System.out.println("No results!");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(i + 1 + ". " + contactList.get(i));
            }
        }
    }

    public static void addNewContact(List<Contact> contactList) {
        System.out.println("Insert contact details!");
        System.out.print("Insert first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Insert last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Insert phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Insert second phone number: ");
        String secondPhoneNumber = scanner.nextLine();
        System.out.print("Insert e-mail: ");
        String email = scanner.nextLine();
        Contact contact = new Contact(firstName, lastName, phoneNumber, secondPhoneNumber, email);
        contactList.add(contact);
    }

    public static void deleteContact(List<Contact> contactList) {
        displayContacts(contactList);
        System.out.print("Select the contact you want to edit: ");
        int chosenContact = scanner.nextInt();
        Contact contact = contactList.get(chosenContact - 1);

        System.out.println("Selected contact is:\n" + contact);
        System.out.println("Are you sure you want to delete this contact? [Y/N]");
        scanner.nextLine();
        String selectedOption = scanner.nextLine();
        if (selectedOption.equalsIgnoreCase("y")) {
            System.out.println("Removed contact:\n" + contact);
            contactList.remove(contact);
        }
    }
}