package ro.jademy;

import ro.jademy.DB.ContactsProvider;

public class Main {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        agenda.contactList = ContactsProvider.getContacts();

        do {
            agenda.showMenu(agenda.contactList);
        } while (true);

    }


}
