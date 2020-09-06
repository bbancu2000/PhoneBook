package ro.jademy;

import org.apache.commons.lang3.StringUtils;
import ro.jademy.DB.ContactsProvider;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    Scanner sc = new Scanner(System.in);
    public List<Contact> contactList = ContactsProvider.getContacts();

    //TODO choose which type of list is better for this APP


    public void showMenu(List<Contact> currentContacts) {
        List<Contact> tempList = currentContacts;
        Contact currentContact = null;

        String choice;
        int choiceInt;

        Operations.printContactList(currentContacts);

        boolean isValidInput = false;
        do {
            System.out.println();
            System.out.println("Please select the index of your contact: ");
            System.out.println("[ Type S for Search ]");
            System.out.println("[ Type A for Add ]");
            System.out.println("[ Type R for Remove ]");
            System.out.println("[ Type X to return to Main Menu ]");
            choice = sc.nextLine();

            if (StringUtils.isNumeric(choice)) {
                currentContact = Operations.getContactFromList(currentContacts, choice);
                if (currentContact != null) {
                    contactSubMenu(currentContact);
                    isValidInput = true;
                }
            } else if (choice.equalsIgnoreCase("s")) {
                // Search
                tempList = Operations.searchContactsFromList(currentContacts);
                showMenu(tempList);
                isValidInput = true;

            } else if (choice.equalsIgnoreCase("a")) {
                // Add a contact
                Operations.addContacts(contactList);
                isValidInput = true;


            } else if (choice.equalsIgnoreCase("r")) {
                //Remove one or more Contacts, by index
                Operations.removeMultiContacts(contactList, currentContacts);
                isValidInput = true;

            } else if (choice.equalsIgnoreCase("x")) {
                //Return to Main Menu
                isValidInput = true;

            } else {
                System.out.println("Invalid input for getContactFromList");
            }

        } while (!isValidInput);
    }

    public void contactSubMenu(Contact contact) {
        Operations.printContact(contact);
        System.out.println();
        System.out.println("[ Type C to Call ]");
        System.out.println("[ Type T to Text ]");
        System.out.println("[ Type E to Edit ]");
        System.out.println("[ Type R to Remove the Contact ]");
        System.out.println("[ Type N to Return to Main Menu ]");

        boolean isValidInput = false;
        String choice;
        do {
            choice = sc.nextLine().toLowerCase();
            switch (choice) {
                case "c":
                    System.out.println("Phone goes  BRRRRRRRRR ... ");
                    isValidInput = true;
                    break;
                case "t":
                    System.out.println("Type your message:");
                    sc.nextLine();
                    System.out.println("Your message has been sent !");
                    isValidInput = true;
                    break;

                case "e":
                    Operations.editContact(contact);
                    Collections.sort(contactList);
                    isValidInput = true;
                    break;

                case "r":
                    Operations.removeSingleContact(contactList, contact);
                    isValidInput = true;
                    break;

                case "n":
                    isValidInput = true;
                    break;

                default:
                    System.out.println("Invalid input for Contact Submenu");

            }

        } while (!isValidInput);


    }

}
