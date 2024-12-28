package phonebookApp;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.*;

/**
 * Write a description of JavaFX class View here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class View
{
    int H = 1280;
    int W = 800;
    
    Model model;
    Controller controller;
    Label  text1, text2, text3;
    TextField  info, field2;
    Image contactIcon;
    ImageView iv;
    
    String[] options = {"addContact", "removeContact", "listContacts", "getContact", "openPhoneBook", "deleteBook", "deleteall"};
    
    GridPane gP;
    TilePane buttonPane;
    
    public void start(Stage window)
    {
        window.setTitle("University of Brighton Phone Book demonstration by Luke Hirst");
        
        gP = new GridPane();
        gP.setId("Layout");
        buttonPane = new TilePane();
        buttonPane.setId("Buttons");
    
        text1 = new Label("The following options are: Add a Contact, Remove a contact, list contacts, open phoneBook, deleteBook, delete All contacts");
        gP.add(text1, 0, 0);
        
        text2 = new Label("What would you like to do first?");
        gP.add(text2, 0, 1);
        
        text3 = new Label("");
        gP.add(text3, 0, 2);
        
        info = new TextField();
        gP.add(info, 1,1 );
        
        field2 = new TextField();
        gP.add(field2, 1, 2);
        
        // Add a new contact icon to the screen
        contactIcon = new Image("/contactIcon.png");
        iv = new ImageView(contactIcon);
        gP.add(iv, 1, 3);
        
        String[] buttonText = { "Add Contact", "Remove Contact", "List Contacts", "Help", "Get Contact", "Open Phonebook", "Delete book", "Delete All contacts" };
        
        for(String text : buttonText) {
            Button btn = new Button(text);
            buttonPane.getChildren().add(btn);
            btn.setOnAction(this::buttonClick);
        }
        
        gP.add(buttonPane, 1, 9);
        Scene s = new Scene(gP, H, W);
        field2.setVisible(false);
        window.setScene(s);
        window.show();
    }
        
    public void buttonClick(ActionEvent event)
    {
        Button btn = (Button) event.getSource();
        if (controller != null)
        {
            String text = btn.getText();
            controller.ActionsPress(text);
        }
    }
    
    public void update(String infoUp)
    {
        if (model != null)
        {
            info.setText(infoUp);  
        }
    }
    
    public void infoClick(ActionEvent event)
    {
        TextField info = (TextField) event.getSource();
        if (controller != null)
        {
            String userText = info.getText();
        }
    }
}
