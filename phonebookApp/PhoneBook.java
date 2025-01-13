package phonebookApp;

import java.util.TreeMap;

/**
 * A simple class to store a list of names and phone numbers.
 *
 * @author Roger
 * @version 2024-CI401-CW-PhoneBookApp
 */
public class PhoneBook
{
    /**
     * a phone book object. 
     * We use a TreeMap to store numbers associated with names. 
     * TreeMap is an ordered map, so when we loop over the map, the entries are
     * in alphabetical order.
     */
    public TreeMap<String, String> phoneNumbers;
    View view = new View();

    /**
     * constructor for objects of class PhoneBook
     */
    public PhoneBook()
    {
        // initialise the phone number store
        phoneNumbers = new TreeMap<String, String>();
    }

    /**
     * clears all the entries from the PhoneBook 
     */
    public void clear()
    {
        // clear the phoneNumbers map
        phoneNumbers.clear();
    }
    
    /**
     * adds a name and phone number to the PhoneBook
     *
     * @param  name  the name of the person
     * @param  number the phone number (as a String)
     */
    public void addPhoneNumber(String name, String number)
    {
        // add the name and number pair to the map
        // note that there is no duplication check here - it simply overwrites
        phoneNumbers.put(name, number);
    }
    /**
     * deletes a name and phone number from the PhoneBook
     * 
     * @param name - Who is the person?
     * @param number - The phone number of the person (as a String)
     * @param remove - Removes the key from the TreeMap
     */
    public void removePhoneNumber(String name, String number)
    {
        // removes the name and number pair from the map
        // No duplication check, as it removing contacts.
        phoneNumbers.remove(name, number);
    }
    
    /**
     * retrieves phone number from the PhoneBook
     *
     * @param  name  the name of the person
     * @return the phone number (as a String) or null if the person is not in the phone book
     */
    public String getPhoneNumber(String name)
    {
        // check if the name is a key in the phoneNumbers map
        if (phoneNumbers.containsKey(name)) {
            // return their phone number if so
            return phoneNumbers.get(name);
        } else {
            // return null if not
            return null;
        }
    } 
    
    /**
     * creates a String listing all the entries in the PhoneBook
     * 
     * @return the listing, with each entry on a separate line
     */
    public String listing()
    {
        String list = "";
        // use keySet to return the Set of map keys. 
        // Sets are ok to use in an enhanced for loop, and in TreeMap, the set is
        // traversed in alphabetical order.
        for (String name:phoneNumbers.keySet()) 
        {
            // add an entry to the end of the list, plus a newline
            list += name + ":" + phoneNumbers.get(name) + "\n";
        }
        return list;
    }
    
    public String listingApp()
    {
        String list = view.info.getText();
        
        for (String name:phoneNumbers.keySet())
        {
            list += name + ":" + phoneNumbers.get(name) + "";
        }
        return list;
    }
    
    /**
     * prints a listing of the PhoneBook on the Console output
     */
    public void printListing()
    {
        System.out.print(listing());
    }
    
    public void printListApp()
    {
        view.text1.setText(listingApp());
    }
}
