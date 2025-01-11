package phonebookApp;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Executes the main application, which is an emulator of a mobile phone contact app in a simplified format.
 * This class contains all of the containers needed for the rest of the application to work.
 */
public class Main extends Application
{
    public static void main(String args[])
    {
        launch(args);
    }
    
    /**
     * This class is responsible for creating new PhoneBook objects, a new model, a new view
     * and a new controller object. It also calls each model and view in different classes.
     */
    @Override
    public void start(Stage window)
    {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();
        
        model.view = view;
        model.controller = controller;
        
        view.model = model;
        view.controller = controller;
        
       controller.model = model;
       controller.view = view;
        
        view.start(window);
    }
}
