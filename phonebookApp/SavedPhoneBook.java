package phonebookApp;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
/**
 * an extension to {@link PhoneBook} which stores the phone data in a file.
 * <p>SavedPhoneBook extends the basic {@link PhoneBook} class by providing {@code save} and 
 * {@code load} methods for storing and retrieving the PhoneBook data in a file.
 *
 * @author 
 * @version 2024-CI401-CW-PhoneBookApp
 */
public class SavedPhoneBook extends PhoneBook
{
    // The name of the file to use for storage (no javadoc comment!)
    private String filename;
    
    /**
     * constructor for objects of class SavedPhoneBook
     * 
     * @param theFileName the name of the file to store the PhoneBook data in
     */
    public SavedPhoneBook(String theFileName)
    {
        super();
        filename = theFileName;
    } 

    /**
     * gets the filename associated with this SavedPhoneBook
     * 
     * @return the filename (a String)
     */
    public String getFileName()
    {
        return filename;
    }
    
    // no setFileName method - no-one can change a filename except inside this class
    
    /**
     * saves PhoneBookData into the file
     * 
     * We use the listing method to create a file which we can later read back in
     * using the load method
     * 
     * The file handling code may generate an IOException, so we wrap it in a try-catch
     * block, which catches any exception and just prints a message (and returns)
     */
    public void save()
    {
        try {
            // create a filewriter, write the listing string to it, and then close the file
            FileWriter f = new FileWriter(filename);
            f.write(listing());
            f.close();
        } catch (IOException e) {
            System.err.println("Save failed for PhoneBookData: " + e.getMessage());
        }
    }
    
    /**
     * Here, the user may want to delete the phoneBook, so here is the functionality to do this - Luke.
     */
    public void delete()
    {
        try
        {
            Files.delete(Paths.get(filename));
        }
        catch (IOException e)
        {
            System.err.println("Sorry, that PhoneBookData does not exist." + e.getMessage());
        }
    }
    
    /**
     * loads PhoneBookData from the file
     * 
     * We open the file and use Scanner with a modified delimiter to read
     * the data from it (which is assumed to be in the format of the listing
     * method)
     * 
     * The file handling code may generate an IOException, so we wrap it in a try-catch
     * block, which catches any exception and just prints a message (and returns, possibly
     * with the data only partially loaded)
     */
    public void load()
    {
        try {
            // Create a Scanner object to read the file
            // Set the delimiter to be : or newline
            FileReader f = new FileReader(filename);
            Scanner input = new Scanner(f);
            input.useDelimiter(":|\n");
            
            // clear the map of any existing data
            clear();
            
            // loop through the data in the file
            while (input.hasNext())
            {
                // read the name
                String name = input.next();
                // check that there is also a number - ignore this name if not
                if (input.hasNext()) 
                {
                    // add the name and number to the map
                    super.addPhoneNumber(name, input.next());
                }
            }
            // close the file before finishing
            f.close();
        } catch (IOException e) {
            // if something went wrong in the 'try' block we ned up here
            // We just print an error message and return (as if nothing had gone
            // wrong)
            System.err.println("Load failed for PhoneBookData: " + e.getMessage());
        }
    }    
    
    
    @Override
    public void addPhoneNumber(String name, String number) {
        super.addPhoneNumber(name, number);
        save();
    }
}
