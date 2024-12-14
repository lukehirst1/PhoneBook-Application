package phonebookApp;
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
        System.exit(0);
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
     */
    public void listContacts()
    {
        if (sPB == null) 
        {
            view.text1.setText("No phonebook loaded");
            view.text2.setVisible(false);
        } 
        else 
        {
            String contacts = phoneBook.listing();
            view.text1.setText("The following contacts are listed: " + contacts);
            view.text2.setVisible(false);
            phoneBook.printListing();
        }
    }
    
    /**
     * Adds a contact to the phoneBook and saves the changes as long as the book is not null.
     */
    public void addContact()
    {
        while (true)
        {
            if (sPB == null) 
            {
                view.text1.setText("No phonebook loaded");
            }
            else 
            {
                String addName = view.info.getText();
                // In this instance, we don't want the program to accept "name" as a result, so this switch provides a check to ensure this doesn't happen.
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
            String addNumber = view.field2.getText();
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
                view.text2.setText("");
                sPB.addPhoneNumber(addName, addNumber);
                sPB.save();   
            }
            break;
        }
    }
}
    
    /**
     * Gets the information of a contact from the phoneBook if it is not null.
     */
    public void getContact()
    {
        while (true)
        {
            if (sPB == null) 
            {
                 view.text1.setText("No phonebook loaded");
                 view.text2.setText("");
            }
            else
            {
                String name = view.info.getText();
                String number = sPB.getPhoneNumber(name);
                view.text1.setText("The following contact details are: " + "Name of contact: " + name + " Number: " + number);
            }
            break;   
        }
    }
    
    /**
     * Deletes a contact from the book, and saves the change.
     */
    public void deleteContact()
    {
        while (true)
        {
            if (sPB == null)
            {
                 view.text1.setText("Sorry, you have no phonebook loaded.");
            }
            else
            {
                // Which contact is to be removed?
                System.out.println("Please input the name and number of the contact you would like to delete from the phonebook.");
                String name = view.info.getText();
                String number = view.field2.getText();
                // Confirms that the contact has been removed from phone book.
                view.text1.setText("Contact deleted from phone book");
                sPB.removePhoneNumber(name, number);
                sPB.save();
            }
            break;
        }
    }
    /**
     * Removes all contacts from a phone book.
     */
    public void deleteAll()
    {
        while (true) {
        System.out.println("WARNING! THIS WILL CLEAR YOUR CURRENT PHONE BOOK!");
        System.out.println("Do you wish to proceed?");
        String confirm = "";
        switch (confirm)
        {
            case "no", "No":
            {
                System.out.println("Returning to menu");
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
                    sPB.phoneNumbers.clear();
                    System.out.println("Phone book cleared.");
                    sPB.save();
                    continue;   
                }
            }
                default:
                {
                    break;
                }   
            }
        }
    }
    /**
     * Deletes a phoneBook from the system.
     */
    public void removeBook()
    {
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
    }
}
