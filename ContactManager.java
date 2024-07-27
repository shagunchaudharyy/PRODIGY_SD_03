import java.util.HashMap;
import java.util.Scanner;

public class ContactManager {

    static HashMap<String, Contact> contacts = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void displayMenu() {
        System.out.println("\nContact Management System");
        System.out.println("1. Add Contact");
        System.out.println("2. View Contacts");
        System.out.println("3. Edit Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addContact() {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        if (contacts.containsKey(name)) {
            System.out.println("A contact with this name already exists.");
            return;
        }

        System.out.print("Enter the phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter the email address: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(name, phone, email);
        contacts.put(name, newContact);
        System.out.println("Contact added successfully!");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        System.out.println("\nContacts:");
        for (String name : contacts.keySet()) {
            Contact contact = contacts.get(name);
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone: " + contact.getPhone());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("------------------");
        }
    }

    static void editContact() {
        System.out.print("Enter the name of the contact to edit: ");
        String name = scanner.nextLine();
        if (!contacts.containsKey(name)) {
            System.out.println("Contact not found.");
            return;
        }

        Contact contact = contacts.get(name);

        System.out.println("\nCurrent contact details:");
        System.out.println("Name: " + contact.getName());
        System.out.println("Phone: " + contact.getPhone());
        System.out.println("Email: " + contact.getEmail());

        System.out.print("Enter the new phone number (or press enter to skip): ");
        String newPhone = scanner.nextLine();
        if (!newPhone.isEmpty()) {
            contact.setPhone(newPhone);
        }

        System.out.print("Enter the new email address (or press enter to skip): ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            contact.setEmail(newEmail);
        }

        System.out.println("Contact details updated successfully!");
    }

    static void deleteContact() {
        System.out.print("Enter the name of the contact to delete: ");
        String name = scanner.nextLine();
        if (!contacts.containsKey(name)) {
            System.out.println("Contact not found.");
            return;
        }

        contacts.remove(name);
        System.out.println("Contact deleted successfully!");
    }
}

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}