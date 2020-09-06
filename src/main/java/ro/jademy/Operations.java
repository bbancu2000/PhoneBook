package ro.jademy;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Operations {
    private static Scanner sc = new Scanner(System.in);



    public static void removeContact(List<Contact> contactList){

    }


    //TODO

    public static List<Contact> getContactsFromList(List<Contact> contactList) {
        List<Contact> tempList = new ArrayList<>();
        int choiceInt;
//        choiceInt = Integer.parseInt(choice);
//        if (choiceInt >= 0 && choiceInt < contactList.size()) {
//            tempList.add(contactList.get(choiceInt));
//            isValidInput = true;
//        }


        boolean isValidInput = false;


        return tempList;
    }





    public static List<Contact> searchContactsFromList(List<Contact> contactList) {

        //TODO separator for search, only ' ' , u can have Ana-Maria, D'Jango,
        // so these chars '-', ' ' ' shouldn't be used for separator.

        //REDUNDANT SET usage , but we do it for the practice
        Set<Contact> startingList = new TreeSet<>(contactList);
        List<Contact> tempList = new ArrayList<>();

        String searchWord;
        System.out.println("Please enter the name of the person");
        searchWord = sc.nextLine();

        String[] words = searchWord.split(" ");
        
        if(words.length > 0) {
            for (String word : words) {
                word = word.toLowerCase();

                for (Contact contact : startingList) {
                        if(contact.getFirstName().toLowerCase().contains(word)
                                || contact.getLastName().toLowerCase().contains(word)
                                || contact.getMainPhone().toLowerCase().contains(word)
                                || contact.getSecondPhone().toLowerCase().contains(word)) {
                            tempList.add(contact);
                        }
                    }
                    if(!tempList.isEmpty()) {
                        startingList.retainAll(tempList);
                    }
                    tempList.clear();
            }
        }


        return new ArrayList<>(startingList);


    }












    public static void printContact(Contact contact) {

    }

    public static void printContactList(List<Contact> contactList) {
        int maxIndexPadding = 3;

        //TODO contactList.size()/  Math.pow(10, maxIndexPadding); ?? cum scot maxIndexPadding din formula asta?



        for (int i = 0 ; i < contactList.size() ; i++) {
            System.out.printf("%"+ maxIndexPadding +"d. " , i );
            //TODO printing only names in main menu ?
            // maybe use printContact method   separately to display all information about contact.
            System.out.println(contactList.get(i));

        }
    }


}
