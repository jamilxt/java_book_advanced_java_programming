package book.advanced_java_programming.chapter_1.lesson_1;

import java.util.List;

public class ContactApp {

    // Lesson: Anonymous Inner Class & Lambda Expression
    public static void main(String[] args) {
        List<Contact> contactList = List.of(
                new Contact("Will Smith", "will@gmail.com", 50, Contact.Gender.MALE),
                new Contact("Ellen Degeneres", "elen@gmail.com", 60, Contact.Gender.FEMALE),
                new Contact("Sheldon Cooper", "shelly@gmail.com", 10, Contact.Gender.MALE),
                new Contact("Jamilur Rahman", "jamilxt@gmail.com", 23, Contact.Gender.MALE));

        ContactService contactService = new ContactService();

        List<Contact> contactAged18To25 = contactService.findContacts(contactList, new FilterCriteria() {
            @Override
            public boolean match(Contact contact) {
                return 18 <= contact.getAge() && contact.getAge() <= 25;
            }
        });

        for (Contact contact : contactAged18To25) {
            System.out.println(contact);
        }

        // Lambda Expression to remove boilerplate code
        List<Contact> contactAged18To25Female = contactService.findContacts(contactList, (Contact contact) -> {
            return 50 <= contact.getAge() && contact.getAge() <= 70 && contact.getGender() == Contact.Gender.FEMALE;
        });

        for (Contact contact : contactAged18To25Female) {
            System.out.println(contact);
        }

    }


}

