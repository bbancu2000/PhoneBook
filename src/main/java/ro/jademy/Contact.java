package ro.jademy;

import java.util.Objects;

public class Contact implements Comparable<Contact> {

    private String firstName;
    private String lastName;
    private String mainPhone;
    private String secondPhone;

    // String used for phone numbers because of
    // "+" for country code
    // "*, #" for certain numbers


    public Contact(String firstName, String lastName, String mainPhone, String secondPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mainPhone = mainPhone;
        this.secondPhone = secondPhone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mainPhone='" + mainPhone + '\'' +
                ", secondPhone='" + secondPhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return mainPhone.equals(contact.mainPhone) &&
                secondPhone.equals(contact.secondPhone) &&
                Objects.equals(firstName, contact.firstName) &&
                Objects.equals(lastName, contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, mainPhone, secondPhone);
    }


    @Override
    public int compareTo(Contact contact) {
        if (this.firstName.toLowerCase().compareTo(contact.firstName.toLowerCase()) == 0) {
            return this.lastName.toLowerCase().compareTo(contact.lastName.toLowerCase());
        }
        return this.firstName.toLowerCase().compareTo(contact.firstName.toLowerCase());
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }


}
