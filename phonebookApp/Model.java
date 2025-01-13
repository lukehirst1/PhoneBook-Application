package phonebookApp;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Write a description of class Model here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Model
{
    View view;
    Controller controller;
    SavedPhoneBook sPB = null;
    PhoneBook phoneBook;
    
    /**
     * When finished, close the program.
     */
    public void endProgram()
    {
        view.text1.setText("Goodbye!");
        view.text2.setText("");
        view.text3.setText("");
        view.field2.setVisible(false);
        System.exit(0);
    }
    
    public void HelpRequested()
    {
        view.text1.setText("What do you need help with?");
        view.text2.setText("");
        String help = view.info.getText();
        view.field2.setVisible(false);
        ArrayList<String> commands = new ArrayList();
        commands.add("Removing a contact");
        commands.add("remove contact");
        commands.add("How do I remove a contact?");
        commands.add("Adding a contact");
        commands.add("add contact");
        commands.add("How do I add a contact to an existing phonebook?");
        commands.add("How do I add a contact?");
        commands.add("Open a Phonebook");
        commands.add("open phonebook");
        commands.add("How do I open a phonebook?");
        commands.add("List all contacts");
        commands.add("list contacts");
        commands.add("How can I list all of my contacts?");
        commands.add("Get a contact");
        commands.add("get contact");
        commands.add("How can I get a contact's information?");
        commands.add("Delete a phonebook");
        commands.add("Delete book");
        commands.add("How can I delete a phonebook?");
        commands.add("Delete all contacts");
        commands.add("How can I delete all contacts from a phonebook?");
        commands.add("That was all");
        commands.add("No thanks");
        commands.add("Thank you, but no");
        commands.add("Nope, that was all thanks!");
        commands.add("no");
        commands.add("No");
        commands.add("create a new phonebook");
        
        switch (help)
        {
            case "Removing a contact", "remove contact", "How do I remove a contact?":
                {
                    view.text1.setText("To remove a contact from the phoneBook, you need to ensure that a active phoneBook is loaded.");
                    view.text2.setText("Then, you navigate to Remove Contact, and input the contact's details, and press Remove Contact");
                    view.text3.setText("Is there anything else I can help you with?");
                    break;
                }
            
            case "Adding a contact", "add contact", "How do I add a contact to an existing phoneBook?", "How do I add a contact?":
            {
                view.text1.setText("To add a contact to a existing phoneBook, you need to ensure that a active phoneBook is loaded");
                view.text2.setText("Then, you navigate to Add Contact, and input the contact's details, and press Add Contact");
                view.text3.setText("Is there anything else I can help you with?");
                break;
            }
            
            case "Open a Phonebook", "open phonebook", "How do I open a phonebook?, create a new phonebook.":
            {
                view.text1.setText("To open a phonebook, navigate to Open Phonebook, and write the phonebook that you wish to open in the text field.");
                view.text2.setText("Is there anything else I can help you with?");
                break;
            }
            
            case "List all contacts", "list contacts", "How can I list all of my contacts?":
            {
                view.text1.setText("To list all contacts in a phonebook, navigate to List Contacts, and click the button");
                view.text2.setText("Please note: This will open a seperate console window, which can be closed without shutting down the program");
                break;
            }
            
            case "Get a contact", "get contact", "How can I get a contact's information?":
            {
                view.text1.setText("To get the information of a contact, navigate to Get Contact, and write the contact's details in the fields");
                view.text2.setText("Then, press Get Contact. Your contact's details will be listed on the screen.");
                view.text3.setText("Is there anything else I can help you with?");
                break;
            }
            
            case "Delete a phonebook", "delete book", "How can I delete a phonebook?":
            {
                view.text1.setText("To delete a phonebook, navigate to Delete Book, and ensure that a phonebook is already loaded.");
                view.text2.setText("It will warn you that it is irreversible. Type Yes, and it will remove it from your system.");
                view.text3.setText("Is there anything else I can help you with?");
                break;
            }
            
            case "Delete all contacts", "How can I delete all contacts from a phonebook?":
            {
                    view.text1.setText("To remove all contacts from the phoneBook, you need to ensure that a active phoneBook is loaded.");
                    view.text2.setText("Then, you navigate to Delete All contacts and Delete All contacts");
                    view.text3.setText("Is there anything else I can help you with?");
                    break;
            }
            
            case "That was all", "No thanks", "Thank you, but no", "Nope, that was all thanks!", "no", "No":
                {
                    view.text1.setText("Glad to hear it. Please don't hesitate to ask again");
                    view.text2.setText("What would you like to do next?");
                    view.text3.setText("");
                    view.field2.setVisible(true);
                    return;
                }
            default:
           {
                if (!commands.contains(help) && !view.info.getText().isEmpty())
                {
                    view.text1.setText("The value: " + help + " appears to not be a parameter.");
                    view.text2.setText("Please try another command");
                }
                else if (commands.contains(help) && !view.info.getText().isEmpty())
                {
                    return;
                }
            }
        }
    }
    
    /**
     * Open the requested phoneBook, or if there is not already one, then create one.
     */
    public void openFile()
    {
        if (view.info.getText().isEmpty())
        {
            view.text1.setText("You must write a name in the box.");
            view.text2.setText("");
            view.field2.setVisible(false);
        }
        else
        {
            String filename = view.info.getText();
            sPB = new SavedPhoneBook(filename);
            sPB.load();
            view.text1.setText("Phonebook name: " + filename + " loaded");
            view.text2.setText("The following options are: Add a Contact, Remove a contact, list contacts, open phoneBook, deleteBook, delete All contacts");
            view.field2.setVisible(true);
        }
    }
    
    /**
     * Lists all contacts if a phonebook is not null.
     * Utilises the terminal window to read the files, as opposed to text fields.
     */
    public void listContacts()
    {
        if (sPB == null) 
        {
            view.text1.setText("No phonebook loaded");
            view.text2.setText("");
        }
        
        else
        {
            try
            {
                String file = view.info.getText();
               FileReader fr = new FileReader(file);
               int content = fr.read();
               view.text1.setText("File opened");
               while (content != -1)
               {
                   System.out.print((char)content);
                   content = fr.read();
               }
               fr.close();
            }
            catch (Exception e)
            {
                view.text1.setText("File not recognised");
                view.text2.setText("");
                view.field2.setVisible(false);
            }
        }
    }
    
    /**
     * Adds a contact to the phoneBook and saves the changes as long as the book is not null.
     */
    public void addContact()
    {
        if (sPB == null)
        {
            view.text1.setText("No phonebook loaded");
            view.text2.setText("");
            view.field2.setVisible(false);
        }
        else
        {
            String addName = view.info.getText();
            String addNumber = view.field2.getText();
            String nameRegex = ".*[0-9].+";
            String numberRegex = ".*[A-Z, a-z, !, £, ., ?, ~, #, @, ;, |].+";
            
            /**
             * does the value contain numbers?
             */
            if (addName.matches(nameRegex) || addNumber.matches(numberRegex))
            {
                /**
                 * Restrict the info from being added.
                 */
                view.text1.setText("ERROR: Illegal value!");
                view.text2.setText("Illegal values are not allowed in the field(s)");
            }
            
            else if (addNumber.length() != 11 && !view.field2.getText().isEmpty())
            {
                view.text1.setText("Number anomaly found. Please try again");
                view.text2.setText("");
            }
            else
            {
                if (view.info.getText().isEmpty())
                {
                    view.text1.setText("Sorry, I cannot add empty values to the file. Please fill in all boxes before continuing");
                    view.text2.setText("You need to fill in the contact name field. This is the top box.");
                }
                if (view.field2.getText().isEmpty())
                {
                    view.text1.setText("Sorry, I cannot add empty values to the file. Please fill in all boxes before continuing");
                    view.text2.setText("You need to fill in the contact number field. This is the bottom box.");
                    view.field2.setVisible(true);
                }
                if (view.info.getText().isEmpty() && view.field2.getText().isEmpty())
                {
                    view.text1.setText("I can't work with empty values. Please fill in all boxes before continuing");
                    view.text2.setText("You need to fill in both boxes");
                    view.field2.setVisible(true);
                }
                else if (!view.info.getText().isEmpty() && !view.field2.getText().isEmpty())
                {
                    view.text1.setText("Contact added to phone book");
                    view.text2.setText("What would you like to do next?");
                    view.field2.setText("");
                    sPB.addPhoneNumber(addName, addNumber);
                    sPB.save();
                }
            }
        }
    }
         /**
          * This is old code from the console app. For legacy purposes, this will be kept here.
          */   
        /*
        while (true)
        {
            if (sPB == null) 
            {
                view.text1.setText("No phonebook loaded");
            }
            else 
            {
                String addName = view.info.getText();
                String addNumber = view.field2.getText();
                

                // In this instance, we don't want the program to accept "name" as a result, so this switch provides a check to ensure this doesn't happen.
            /*
            switch (addName)
            {
                case "name", "Name", "nAmE":
                {
                    // Not a valid name.
                    view.text1.setText("Sorry, that is not a valid name. Please try again.");
                    //  System.out.println("Sorry, that is not a valid name. Please try again.");
                    // Return back to the options.
                    continue;
                }
                default:
                {
                    // Continue.
                    break;
                }
                        
            }  
            // Here, I want to catch "number", and ban it from being added into the phonebook.
            switch (addNumber)
            {
                case "number", "Number", "nUmBeR", "num":
                {
                    // Not a valid number.
                    view.text1.setText("Sorry, that is not a valid number. Please try again.");
                    // Return back to the options.
                    continue;
                }
                    default:
                {
                    // Continue.
                    break;
                }
            }
            
            if (view.info.getText().isEmpty())
            {
                view.text1.setText("Sorry, I cannot add empty values to the file. Please fill in all boxes before continuing");
                view.text2.setText("You need to fill in the contact name field. This is the top box.");
            }
            else if (view.field2.getText().isEmpty())
            {
                view.text1.setText("Sorry, I cannot add empty values to the file. Please fill in all boxes before continuing");
                view.text2.setText("You need to fill in the contact number field. This is the bottom box.");
            }
            else
            {
                view.text1.setText("Contact added to phone book");
                view.text2.setVisible(false);
                sPB.addPhoneNumber(addName, addNumber);
                sPB.save();   
            }
            break;
            */
    
    /**
     * Gets the information of a contact from the phoneBook if it is not null.
     */
    public void getContact()
    {
            if (sPB == null) 
            {
                 view.text1.setText("No phonebook loaded");
                 view.text2.setText("");
            }
            
            else if (view.info.getText().isEmpty())
            {
                view.text1.setText("Sorry, I cannot get empty values from the file. Please fill in all boxes before continuing");
                view.text2.setText("You need to fill in the contact name field. This is the top box.");
                view.field2.setVisible(false);
            }
            else
            {
                String name = view.info.getText();
                String number = sPB.getPhoneNumber(name);
                String nameRegex = ".*[0-9].+";
                
                if (name.matches(nameRegex))
                {
                    view.text1.setText("ERROR: Illegal value!");
                    view.text2.setText("Illegal values are not allowed in the field!!");
                }
                
                else if (!view.info.getText().isEmpty())
                {
                    view.text1.setText("The following contact details are: ");
                    view.text2.setText("Name of contact: " + name + " Number: " + number);
                    view.field2.setVisible(true);
                }
            }
    }
    
    /**
     * Deletes a contact from the book, and saves the change.
     */
    public void deleteContact()
    {
        if (sPB == null)
        {
            view.text1.setText("Sorry, you have no phonebook loaded.");
            view.text2.setText("");
        }
        else
        {
            /**
             * What contact will be deleted from the phoneBook?
             */
            // Redundant - System.out.println("Please input the name and number of the contact you would like to delete from the phonebook.");
            String name = view.info.getText();
            String number = view.field2.getText();
            view.field2.setVisible(true);
            String nameRegex = ".*[0-9].+";
            String numberRegex = ".*[A-Z, a-z, !, £, ., ?, ~, #, @, ;, |].+";
            
            if (name.matches(nameRegex) || number.matches(numberRegex))
            {
                view.text1.setText("ERROR: Illegal value!");
                view.text2.setText("Illegal values are not allowed in the field(s)");
            }
            else if (number.length() != 11 && !view.field2.getText().isEmpty())
            {
                view.text1.setText("Number anomaly found. Please try again");
                view.text2.setText("");
            }
            else
            {
                /**
                 * Are the fields filled in properly?
                 */
                if (view.info.getText().isEmpty())
                {
                    view.text1.setText("I can't delete a contact without both fields being filled in.");
                    view.text2.setText("You need to fill in the top field.");
                }
                if (view.field2.getText().isEmpty())
                {
                    view.text1.setText("I can't delete a contact without both fields being filled in.");
                    view.text2.setText("You need to fill in the bottom field.");
                }
                if (view.field2.getText().isEmpty() && view.info.getText().isEmpty())
                {
                    view.text1.setText("I can't delete a contact without both fields being filled in.");
                    view.text2.setText("You need to fill in both fields.");
                }
                else if (!view.info.getText().isEmpty() && !view.field2.getText().isEmpty())
                {
                    // Confirms that the contact has been removed from phone book.
                    view.text1.setText("Contact deleted from phone book");
                    view.text2.setText("What would you like to do next?");
                    sPB.removePhoneNumber(name, number);
                    sPB.save();   
                }
            }
        }
    }
    /**
     * Removes all contacts from a phone book.
     */
public void deleteAll()
{
    if (sPB == null)
    {
        view.text1.setText("Sorry, you have no phonebook loaded.");
        view.text2.setText("");
    }
    else
    {
        view.text1.setText("WARNING! THIS WILL CLEAR YOUR CURRENT PHONE BOOK!");
        view.text2.setText("Do you wish to proceed?");
        view.text3.setText("");
        view.field2.setVisible(false);
        String confirm = view.info.getText();
        ArrayList<String> confirmation = new ArrayList();
        confirmation.add("no");
        confirmation.add("No");
        confirmation.add("yes");
        confirmation.add("Yes");
        
        switch (confirm)
        {    
            case "no", "No":
            {
                view.text1.setText("Returning to menu");
                view.text1.setText("What would you like to do next?");
                view.text2.setText("");
                break;
            }
            case "yes", "Yes":
            {
                if (sPB == null)
                {
                    view.text1.setText("Sorry, you have no phonebook loaded.");
                    break;
                }
                else
                {
                    sPB.phoneNumbers.clear();
                    view.text1.setText("Phone book cleared.");
                    view.field2.setVisible(true);
                    view.text2.setText("What action would you like to perform next");
                    sPB.save();
                    break;
                }
            }
            default:
            {
                if (!confirmation.contains(confirm) && !view.info.getText().isEmpty())
                {
                    view.text1.setText("The value: " + confirm + " appears to not be a parameter.");
                    view.text2.setText("Please try another command");
                }
                else if (confirmation.contains(confirm) && !view.info.getText().isEmpty())
                {
                    return;
                }
        }
    }
}
}
    /**
     * Deletes a phoneBook from the system.
     */
    public void removeBook()
    {
        if (sPB == null)
        {
            view.text1.setText("Sorry, you have no phonebook loaded.");
            view.text2.setText("");
        }
        else
        {
            view.text1.setText("WARNING! THIS WILL DELETE THE CURRENT PHONE BOOK!");
            view.text2.setText("THIS CHANGE IS IRREVERSIBLE!!");
            view.text3.setText("Do you wish to proceed?");
            view.field2.setVisible(false);
            String confirm = view.info.getText();
            ArrayList<String> confirmation = new ArrayList();
            confirmation.add("no");
            confirmation.add("No");
            confirmation.add("yes");
            confirmation.add("Yes");
            
            switch (confirm)
            {
                case "no", "No":
                {
                    view.text1.setText("What would you like to do next?");
                    view.text2.setText("");
                    view.text3.setText("");
                    break;
                }
                case "yes", "Yes":
                {
                    if (sPB == null)
                    {
                        view.text1.setText("Sorry, you have no phonebook loaded.");
                        view.text2.setText("");
                        view.text3.setText("");
                        break;
                    }
                    else
                    {
                        sPB.delete();
                        view.text1.setText("File deleted.");
                        view.text2.setText("What would you like to do next?");
                        view.field2.setVisible(true);
                        view.text3.setText("");
                        break;
                    }
                }
                default:
                {
                    if (!confirmation.contains(confirm) && !view.info.getText().isEmpty())
                    {
                        view.text1.setText("The value: " + confirm + " appears to not be a parameter.");
                        view.text2.setText("Please try another command");
                        view.text3.setText("");
                    }
                    else if (confirmation.contains(confirm) && !view.info.getText().isEmpty())
                    {
                        return;
                    }
                }
            }
        }
        
        /**
         * Obsolete code. Kept for legacy purposes.
         */
        /*
        while (true)
        {
            System.out.println("WARNING! THIS WILL DELETE THE CURRENT PHONE BOOK!");
            System.out.println("THIS CHANGE IS IRREVERSIBLE!!");
            System.out.println("Do you wish to proceed?");
            String confirm = "";
            
            switch (confirm)
            {
                case "no", "No":
                {
                    System.out.println("Returning to menu...");
                    continue;
                }
                case "yes", "Yes":
                {
                    if (sPB == null)
                    {
                        System.out.format("Sorry, you have no phonebook loaded%n");
                        continue;
                    }
                    else
                     {
                        sPB.delete();
                        System.out.println("File deleted.");
                        continue;   
                    }   
                }
            }
        }
        */
    }
}
