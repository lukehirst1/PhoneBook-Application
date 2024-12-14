package phonebookApp;

import java.util.Scanner;

/**
 * A simple Phone Book application
 * 
 * <p> PhoneBookApp is a program  which provides access to SavedPhoneBook instances.
 * It runs a Scanner loop which reads commands to load a Phone Book (from a file),
 * list its contents and add and get phone numbers. Numbers are stored in the
 * file so they will be remembered if you run the program again.
 * 
 * <p> The commands are:
 * <ul>
 * <li> open filename - open the phonebook in the given filename 
 * (if there is no such file, it creates a new one)
 * <li> list - show all the numbers in the phone book
 * <li> add name number - add a name and number to the phone book
 * <li> get name - find the number for someone
 * <li> end - exit the program
 * </ul>
 * 
 * @author 
 * @version 2024-CI401-CW-PhoneBookApp
 */
public class PhoneBookApp
{
    /**
     * run() - run the app (called from the main method stub)
     */
    public void run() {
        System.out.println("Command instruction:");
        System.out.println("open (Your file here) - open the phonebook in the given filename if there is no such file, it creates a new one");
        System.out.println("list - show all the name and number pairs in the phone book");
        System.out.println("add - add a name and number to the phone book");
        System.out.println("get - find the number for someone");
        System.out.println("delete - remove a name and number from the phone book");
        System.out.println("deleteall - removes ALL contacts and numbers from the phone book");
        System.out.println("deleteBook - deletes the Phonebook from the system.");
        System.out.println("exit - exit the program");
        SavedPhoneBook phonebook = null;
        Scanner input = new Scanner(System.in);
        while (true) {
            // Amending writing to What is the command you intend to perform? From Command?
            System.out.format("What is the command you intend to perform?");
            String command = input.next();
            switch (command) {
                // Added another way to exit the program.
                case "end", "exit":
                    System.out.format("Goodbye!%n");
                    return;
                case "open":
                    {String filename = input.next();
                    phonebook = new SavedPhoneBook(filename);
                    phonebook.load();
                    System.out.format("Phonebook %s loaded%n", filename);}
                    break;
                case "list":
                    if (phonebook == null) {
                        System.out.format("No phonebook loaded%n");
                    } else {
                        phonebook.printListing();
                    }
                    break;
                case "add":
                    if (phonebook == null) {
                        System.out.format("No phonebook loaded%n");
                    } else {
                        System.out.println("Please input the contact name: ");
                        String name = input.next();
                        // In this instance, we don't want the program to accept "name" as a result, so this switch provides a check to ensure this doesn't happen.
                        switch (name)
                        {
                            case "name", "Name", "nAmE":
                                {
                                    // Not a valid name.
                                    System.out.println("Sorry, that is not a valid name. Please try again.");
                                    // Return back to the options.
                                    continue;
                                }
                            default:
                                {
                                    // Continue.
                                    break;
                                }
                        }
                            System.out.println("Please input the contact number: ");
                            String number = input.next();
                            // Here, I want to catch "number", and ban it from being added into the phonebook.
                            switch (number)
                            {
                                case "number", "Number", "nUmBeR", "num":
                                    {
                                        // Not a valid number.
                                        System.out.println("Sorry, that is not a valid number. Please try again.");
                                        // Return back to the options.
                                        continue;
                                    }
                                default:
                                    {
                                        // Continue.
                                        break;
                                    }
                            }
                            System.out.println("Contact added to phone book");
                            phonebook.addPhoneNumber(name, number);
                            phonebook.save();
                    }
                    break;
                case "get":
                    if (phonebook == null) {
                        System.out.format("No phonebook loaded%n");
                    } else {
                        String name = input.next();
                        String number = phonebook.getPhoneNumber(name);
                        System.out.format("%s's number is %s%n", name, number);
                    }
                    break;
                    // This function allows users to delete contacts from the phone.
                case "delete", "remove":
                    if (phonebook == null)
                    {
                        System.out.format("Sorry, you have no phonebook loaded%n");
                    }
                    else
                    {
                        // Which contact is to be removed?
                        System.out.println("Please input the name and number of the contact you would like to delete from the phonebook.");
                        String name = input.next();
                        String number = input.next();
                        // Confirms that the contact has been removed from phone book.
                        System.out.println("Contact deleted from phone book");
                        phonebook.removePhoneNumber(name, number);
                        phonebook.save();
                    }
                    break;
                case "deleteall", "removeall":
                    {
                        System.out.println("WARNING! THIS WILL CLEAR YOUR CURRENT PHONE BOOK!");
                        System.out.println("Do you wish to proceed?");
                        String confirm = input.next();
                        switch (confirm)
                        {
                            case "no", "No":
                            {
                                System.out.println("Returning to menu");
                                continue;
                            }
                            case "yes", "Yes":
                                {
                                    if (phonebook == null)
                                    {
                                        System.out.format("Sorry, you have no phonebook loaded%n");
                                        continue;
                                    }
                                    else
                                    {
                                        phonebook.phoneNumbers.clear();
                                        System.out.println("Phone book cleared.");
                                        phonebook.save();
                                        continue;   
                                    }
                                }
                            default:
                                {
                                    break;
                                }
                        }
                    }
                case "deleteBook", "removeBook":
                    {
                        System.out.println("WARNING! THIS WILL DELETE THE CURRENT PHONE BOOK!");
                        System.out.println("THIS CHANGE IS IRREVERSIBLE!!");
                        System.out.println("Do you wish to proceed?");
                        String confirm = input.next();
                        
                        switch (confirm)
                        {
                            case "no", "No":
                            {
                                System.out.println("Returning to menu...");
                                continue;
                            }
                            case "yes", "Yes":
                            {
                                    if (phonebook == null)
                                    {
                                        System.out.format("Sorry, you have no phonebook loaded%n");
                                        continue;
                                    }
                                    else
                                    {
                                        phonebook.delete();
                                        System.out.println("File deleted.");
                                        continue;   
                                    }   
                            }
                        }
                    }
            }
            input.nextLine();
        }
    }
        
    /** 
     * main(String[] args) - the standard main method stup
     */         
    public static void main(String[] args) {
        new PhoneBookApp().run();
    }
}
