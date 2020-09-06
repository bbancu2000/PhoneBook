package ro.jademy;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Operations {
    private static Scanner sc = new Scanner(System.in);

    public static void removeSingleContact(List<Contact> allContactsList, Contact contact) {

        System.out.println("Are you sure you want to delete?  [ Type Y/N ]");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Removed Contact: " + contact.toString());
            allContactsList.remove(contact);
        }

    }


    public static void removeMultiContacts(List<Contact> allContactsList, List<Contact> currentContactList) {

        System.out.println("Please enter the contact index/es,  you want to remove");
        System.out.println("Separator: (Space)");

        String choice = sc.nextLine();
        String[] indexes = choice.split(" ");

        List<Contact> removedContacts = new ArrayList<>();
        int indexNr = 0;

        for (String indexOfChoice : indexes) {
            try {
                indexNr = Integer.parseInt(indexOfChoice);
                removedContacts.add(currentContactList.get(indexNr));
            } catch (Exception e) {
            }
        }

        if (!removedContacts.isEmpty()) {
            System.out.println("Contacts to be removed:");
            for (Contact removedContact : removedContacts) {
                System.out.println("Contact: " + removedContact);

            }
            System.out.println("Do you want to remove this/these contacts? [ Type Y/N ]");
            String confirmation = sc.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                for (Contact removedContact : removedContacts) {
                    allContactsList.remove(removedContact);
                }
                System.out.println("Successfully removed: " + removedContacts.size() + " contacts.");
            }
        }

    }


    public static void editContact(Contact contact) {
        String choice = "";
        boolean isValidInput = false;
        do {
            System.out.println();
            System.out.println("What would you like to edit ?");
            System.out.println("1. First-Name");
            System.out.println("2. Last-Name");
            System.out.println("3. MainPhone");
            System.out.println("4. SecondPhone");
            System.out.println("N. To Return to Main Menu");
            choice = sc.nextLine().toLowerCase();
            switch (choice) {

                case "1":
                    //firstname
                    boolean isValidFirstName = false;
                    do {
                        System.out.println("Please enter the new First-Name [Minimum 1 char]");
                        String firstName = sc.nextLine();

                        if (firstName.length() > 0) {
                            contact.setFirstName(firstName);
                            isValidFirstName = true;
                        }
                    } while (!isValidFirstName);
                    System.out.println("First-Name edited succesfully");
                    break;

                case "2":
                    //lastname
                    System.out.println("Please enter the new Last-Name [Minimum 1 char]");
                    String lastName = sc.nextLine();
                    contact.setLastName(lastName);
                    System.out.println("Last-Name edited succesfully");
                    break;

                case "3":
                    // mainphone
                    System.out.println("Please enter the new Main-Phone [Minimum 1 char]");
                    String mainPhone = sc.nextLine();
                    contact.setMainPhone(mainPhone);
                    System.out.println("Number edited succesfully");
                    break;

                case "4":
                    // secondphone
                    System.out.println("Please enter the new Second-Phone [Minimum 1 char]");
                    String secondPhone = sc.nextLine();
                    contact.setSecondPhone(secondPhone);
                    System.out.println("Second-Phone edited succesfully");
                    break;

                case "n":
                    isValidInput = true;
                    break;

                default:
                    System.out.println("Invalid input for editContact");
            }
        }
        while (!isValidInput);


    }


    //TODO

    public static Contact getContactFromList(List<Contact> contactList, String choice) {
        int choiceInt = -1;
        try {
            choiceInt = Integer.parseInt(choice);
        } catch (Exception e) {
        }

        if (choiceInt >= 0 && choiceInt < contactList.size()) {
            return contactList.get(choiceInt);
        }
        return null;
    }


    public static List<Contact> searchContactsFromList(List<Contact> contactList) {

        //TODO separator for search, only ' ' , u can have Ana-Maria, D'Jango,
        // so these chars '-', ' ' ' shouldn't be used for separator.

        //REDUNDANT SET usage , but we do it for the practice
        Set<Contact> startingList = new TreeSet<>(contactList);
        List<Contact> tempList = new ArrayList<>();

        String searchWord;
        System.out.println("Enter your search-word: ");
        searchWord = sc.nextLine();

        String[] words = searchWord.split(" ");

        if (words.length > 0) {
            for (String word : words) {
                word = word.toLowerCase();

                for (Contact contact : startingList) {
                    if (contact.getFirstName().toLowerCase().contains(word)
                            || contact.getLastName().toLowerCase().contains(word)
                            || contact.getMainPhone().toLowerCase().contains(word)
                            || contact.getSecondPhone().toLowerCase().contains(word)) {
                        tempList.add(contact);
                    }
                }
                if (!tempList.isEmpty()) {
                    startingList.retainAll(tempList);
                }
                tempList.clear();
            }
        }
        return new ArrayList<>(startingList);
    }


    public static void printContact(Contact contact) {
        //TODO sa arate intr-un fel
        System.out.println(contact);


    }

    public static void printContactList(List<Contact> contactList) {
        int maxIndexPadding = 3;

        //TODO contactList.size()/  Math.pow(10, maxIndexPadding); ?? cum scot maxIndexPadding din formula asta?

        System.out.println();
        for (int i = 0; i < contactList.size(); i++) {
            System.out.printf("%" + maxIndexPadding + "d. ", i);
            //TODO printing only names in main menu ?

            System.out.println(contactList.get(i));

        }
    }


    public static void addContacts(List<Contact> contactList) {
        String firstName;
        do {
            System.out.println("Please enter the First Name");
            firstName = sc.nextLine();
        } while (firstName.length() == 0);
        System.out.println("Please enter the Last Name");
        String lastName = sc.nextLine();
        System.out.println("Please enter the Main Phone");
        String mainPhone = sc.nextLine();
        System.out.println("Please enter the Second  Phone");
        String secondPhone = sc.nextLine();
        Contact newContact = new Contact(firstName, lastName, mainPhone, secondPhone);
        System.out.println("The contact : " + newContact);
        System.out.println("Do you want to keep it? [ Type Y / N ]");
        String confirmation = sc.nextLine();
        if (confirmation.equalsIgnoreCase("y")) {
            System.out.println(" The contact " + newContact + " has been successfully added.");
            contactList.add(newContact);
            Collections.sort(contactList);
        }
    }


}
