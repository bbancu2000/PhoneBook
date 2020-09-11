package ro.jademy.model;

import ro.jademy.service.IOService;
import ro.jademy.service.SearchService;

import java.util.List;
import java.util.Scanner;

import static ro.jademy.model.Operations.*;

public class Agenda {

    private static final String FILE_NAME = "contacts.csv";
    Scanner scanner = new Scanner(System.in);

    SearchService searchService = new SearchService();
    IOService ioService = new IOService();
    List<Contact> contacts = ioService.readContacts(FILE_NAME);

    public void showMenu() {
        System.out.println();
        System.out.println("-------- This is your agenda! ----");
        System.out.println();
        System.out.println("- 1. Display all contacts --------");
        System.out.println("- 2. Add new contact -------------");
        System.out.println("- 3. Edit an existing contact-----");
        System.out.println("- 4. Delete contact --------------");
        System.out.println("- 5. Search contacts -------------");
        System.out.println("- 6. Exit ------------------------");

        chooseOption();
    }

    public void chooseOption() {

        System.out.print("Choose an option: ");
        String selectedOption = scanner.nextLine();

        switch (selectedOption) {
            case "1":
                displayContacts(contacts);
                showMenu();
                break;
            case "2":
                addNewContact(contacts);
                ioService.writeContact(contacts, FILE_NAME);
                showMenu();
                break;
            case "3":
                showEditMenu();
                break;
            case "4":
                deleteContact(contacts);
                showMenu();
                break;
            case "5":
                showSearchMenu();
                break;
            case "6":
                System.exit(0);
                break;
            default:
                System.out.println("Choose a correct option!");
                chooseOption();
        }
    }

    public void showEditMenu() {
        System.out.print("Please insert the word for searching: ");
        String value = scanner.nextLine();
        displayContacts(searchService.searchContact(contacts, value));

        System.out.print("Select the contact number you want to edit: ");
        int chosenContact = scanner.nextInt();
        Contact contact = contacts.get(chosenContact - 1);

        System.out.println("Selected contact is:\n" + contact);

        System.out.println();
        System.out.println("What property do you want to edit? Please insert number");
        System.out.println("1. First name");
        System.out.println("2. Last name");
        System.out.println("3. Phone number");
        System.out.println("4. Second phone number");
        System.out.println("5. E-mail");
        System.out.println("6. Back to previous menu");

        int selectedOption = scanner.nextInt();
        scanner.nextLine();
        switch (selectedOption) {
            case 1:
                System.out.print("New first name: ");
                String newFirstName = scanner.nextLine();
                contact.setFirstName(newFirstName);
                contacts.set(chosenContact - 1, contact);
                System.out.println("You successfully modified contact:\n" + contact);
                ioService.writeContact(contacts, FILE_NAME);
                makeDecision();
                break;
            case 2:
                System.out.print("New last name: ");
                String newLastName = scanner.nextLine();
                contact.setLastName(newLastName);
                contacts.set(chosenContact - 1, contact);
                System.out.println("You successfully modified contact:\n" + contact);
                ioService.writeContact(contacts, FILE_NAME);
                makeDecision();
                break;
            case 3:
                System.out.print("New phone number: ");
                String newPhoneNumber = scanner.nextLine();
                contact.setPhoneNumber(newPhoneNumber);
                contacts.set(chosenContact - 1, contact);
                System.out.println("You successfully modified contact:\n" + contact);
                ioService.writeContact(contacts, FILE_NAME);
                makeDecision();
                break;
            case 4:
                System.out.print("New second phone number: ");
                String newSecondPhoneNumber = scanner.nextLine();
                contact.setSecondPhoneNumber(newSecondPhoneNumber);
                contacts.set(chosenContact - 1, contact);
                System.out.println("You successfully modified contact:\n" + contact);
                ioService.writeContact(contacts, FILE_NAME);
                makeDecision();
                break;
            case 5:
                System.out.print("New email: ");
                String newEmail = scanner.nextLine();
                contact.setEmail(newEmail);
                contacts.set(chosenContact - 1, contact);
                System.out.println("You successfully modified contact:\n" + contact);
                ioService.writeContact(contacts, FILE_NAME);
                makeDecision();
                break;
            case 6:
                showMenu();
                break;
            default:
                System.out.println("Choose a correct option!");
                showEditMenu();
        }
    }

    public void makeDecision() {
        System.out.println("Do you want to edit another contact? [Y/N]");
        String selectedOption;
        do {
            selectedOption = scanner.nextLine();
            if (selectedOption.equalsIgnoreCase("y")) {
                showEditMenu();
            } else {
                showMenu();
            }
        } while (!selectedOption.equalsIgnoreCase("n"));
    }

    public void showSearchMenu() {
        System.out.println();
        System.out.println("1. Search contacts by first name");
        System.out.println("2. Search contacts by last name");
        System.out.println("3. Search contacts by phone number");
        System.out.println("4. Search contacts by e-mail");
        System.out.println("5. Search by any criteria");
        System.out.println("6. Back to previous menu");

        System.out.print("Choose an option: ");
        String selectedOption = scanner.nextLine();

        switch (selectedOption) {
            case "1":
                System.out.print("Please insert the first name: ");
                String firstName = scanner.nextLine();
                displayContacts(searchService.searchContactByFirstName(contacts, firstName));
                showSearchMenu();
                break;
            case "2":
                System.out.print("Please insert the last name: ");
                String lastName = scanner.nextLine();
                displayContacts(searchService.searchContactByLastName(contacts, lastName));
                showSearchMenu();
                break;
            case "3":
                System.out.print("Please insert the phone number: ");
                String phoneNumber = scanner.nextLine();
                displayContacts(searchService.searchContactByPhoneNumber(contacts, phoneNumber));
                showSearchMenu();
                break;
            case "4":
                System.out.print("Please insert the email: ");
                String email = scanner.nextLine();
                displayContacts(searchService.searchContactByEmail(contacts, email));
                showSearchMenu();
                break;
            case "5":
                System.out.print("Please insert the word you are looking for: ");
                String word = scanner.nextLine();
                displayContacts(searchService.searchContact(contacts, word));
                showSearchMenu();
                break;
            case "6":
                showMenu();
                break;
            default:
                System.out.println("Choose a correct option!");
                showSearchMenu();
        }
    }
}