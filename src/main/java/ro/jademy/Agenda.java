package ro.jademy;

import org.apache.commons.lang3.StringUtils;
import ro.jademy.DB.ContactsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    Scanner sc = new Scanner(System.in);
    public List<Contact> contactList = ContactsProvider.getContacts();

    //TODO choose which type of list is better for this APP


    public void showMenu(List<Contact> contacts) {
        List<Contact> tempList = contacts;
        Contact currentContact = null;

        String choice;
        int choiceInt;

        Operations.printContactList(contacts);

        boolean isValidInput = false;
        do {
            System.out.println("Please select the index of your contact: ");

            System.out.println("[ Or Type S for Search ]");
            System.out.println("[ Or Type A for Add ]");
            System.out.println("[ Or Type R for Remove ]");
            System.out.println("[ Or Type X to return to Main Menu ]");
            choice = sc.nextLine();


            if (StringUtils.isNumeric(choice)) {
                choiceInt = Integer.parseInt(choice);
                tempList = Operations.getContactsFromList(contacts);


            } else if (choice.equalsIgnoreCase("s")) {
                tempList = Operations.searchContactsFromList(contacts);

                showMenu(tempList);
                isValidInput = true;

            } else if (choice.equalsIgnoreCase("a")) {
                //TODO Add


            } else if (choice.equalsIgnoreCase("r")) {
                //TODO Add

            } else if (choice.equalsIgnoreCase("x")){

                isValidInput = true;

            } else {
                System.out.println("Invalid input for getContactFromList");
            }

        } while (!isValidInput);





    }

    public void contactSubMenu() {

    }

}
