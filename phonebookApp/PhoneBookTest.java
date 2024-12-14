package phonebookApp;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * a test class for the {@link PhoneBook} class. 
 * 
 * Note that we cannot directly test 
 * the printing method {@code printListing}.
 *
 * @author 
 * @version 2024-CI401-JavaIO
 */
public class PhoneBookTest
{
    
    /**
     * constructor for objects of class PhoneBookTest
     */
    public PhoneBookTest()
    {
    }
    
    /**
     * tests addPhoneNUmber and getPhoneNumber.
     * 
     * <p>Checks that the addPhoneNumber method correctly adds entries to the PhoneBook,
     * and that getPhoneNumber retrieves numbers and returns null for unknown names
     */
    @Test
    public void TestAddPhoneNumber()
    {
        PhoneBook p = new PhoneBook();
        p.addPhoneNumber("John", "12345");
        p.addPhoneNumber("Mary", "09877");
        
        assertEquals("First phone number stored", p.getPhoneNumber("John"), "12345");
        assertEquals("Second phone number stored", p.getPhoneNumber("Mary"), "09877");
        assertNull("Unknown key", p.getPhoneNumber("Bill"));
    }    
    
    /**
     * tests that the listing method returns the expected string
     */
    @Test
    public void TestListing()
    { 
        PhoneBook p = new PhoneBook();
        p.addPhoneNumber("John", "12345");
        assertEquals("Generate listing", p.listing(),"John:12345\nMary:09877\n");
    }    
    
    /**
     * tests that the getPhoneNumber method returns the expected string
     */
    @Test
    public void TestGetPhoneNumber()
    { 
       // add your code here if you want to Junit getPhoneNumber
    }    
}


