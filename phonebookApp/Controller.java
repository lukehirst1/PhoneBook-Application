package phonebookApp;


/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controller
{
    Model model;
    View view;
    
    public void ActionsPress(String action)
    {
        switch (action)
        {
            case "Add Contact":
                model.addContact();
                break;
                
            case "Open Phonebook":
                model.openFile();
                break;
                
            case "List Contacts":
                model.listContacts();
                break;
                
            case "Get Contact":
                model.getContact();
                break;
                
            case "Remove Contact":
                model.deleteContact();
                break;
                
            case "Delete All contacts":
                model.deleteAll();
                break;
                
            case "Delete book":
                model.removeBook();
                break;
                
            case "Help":
                model.HelpRequested();
                break;
                
            default:
                break;
        }
    }
}
