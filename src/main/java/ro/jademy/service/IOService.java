package ro.jademy.service;

import ro.jademy.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IOService {
    private static String header;

    public List<Contact> readContacts(String fileName) {
        List<Contact> contacts = new ArrayList<>();
        Collections.sort(contacts);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            header = reader.readLine();
            System.out.println(header);

            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Contact contact = new Contact(values[0], values[1], values[2], values[3], values[4]);
                contacts.add(contact);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File " + fileName + " not found on disk");
        } catch (IOException ex) {
            System.out.println("Failed to read line from file");
        }
        return contacts;
    }

    public void writeContact(List<Contact> contacts, String fileName) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false));

            // add the header
            bufferedWriter.write(header);
            bufferedWriter.newLine();

            Collections.sort(contacts);

            contacts.forEach(contact -> {
                try {
                    bufferedWriter.write(contact.asCsvLine());
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
