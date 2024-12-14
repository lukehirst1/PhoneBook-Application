package phonebookApp;


/**
 * PhonebookApp, which is a simple Phone Book application and uses many of the techniques we have learned.
 * 
 * <p>It contains two classes: a simple {@link PhoneBook} class which stores 
 * names and phone numbers and {@link SavedPhoneBook} which also stores the information in a file. 
 * It also contains a unit test class {@link PhoneBookTest}
 * which tests PhoneBook class.
 * 
 * <p>There is also a {@link PhoneBookApp} class, which runs as a program (using its run method, 
 * or the standard 'main' method, and allows you to save and retrieve phone numbers from a file.
 * 
 * <h2>Project features</h2>
 * <p>This code includes the following features which will all gain marks if you use them in 
 * your project code:
 * 
 * <ul>
 * <li>control statements (loops, if etc)</li>
 * <li>using classes, objects and methods</li>
 * <li>inheritance</li>
 * <li>encapsulation and protected variables</li>
 * <li>using collection classes (TreeMap)</li>
 * <li>JUnit tests</li>
 * <li>Javadoc comments and compiled documentation</li>
 * <li>code comments</li>
 * <li>using file IO for persistent storage</li>
 * </ul>
 * 
 * <h2>What we have not covered</h2>
 * <p>There are a couple of features here which we have not covered in class, but should
 * be easy to use if you want to.
 * <ul>
 * <li> {@code TreeMap} - the map class we are using is TreeMap instead of HashMap. This
 *      is because TreeMap stores its entries in alphabetical order, which is what we
 *      want for a phone book. (HashMap stores them in random order.) TreeMap is used
 *      just like HashMap, so you can use the HashMap.</li>
 * <li> We use the standalone tag {@literal @throws} to document IOExceptions which our methods 
 *      may throw.<br> 
 *      The format is: {@literal @throws} IOException reason why the exception might be thrown</li>
 * <li> {@code package.html} - one of the links at the top of the Javadoc documentation 
 *      files points to {@code PACKAGE}. This file describes the whole program and lists 
 *      the classes in it. The description comes from a file called {@code package.html} 
 *      in your project folder (with your java files). This is just an HTML file, but can 
 *      include Javadoc tags etc.</li>
 * </ul>     
 * 
 * @author 
 * @version 2024-CI401-CW-PhoneBookApp
 */
public class Coursework
{
    // update the PhoneBookApp to a GUI application
    //you could add more commands to the app, eg delete, help
}
