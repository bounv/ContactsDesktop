package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static java.awt.SystemColor.text;

public class Controller implements Initializable {
    @FXML
    ListView list;

    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void addContact() {
        if(name.getText().isEmpty() || phone.getText().isEmpty() || phone.getText().isEmpty()) {
            System.out.println("All three fields is required!");
        } else {
            Contact c = new Contact(name.getText(), phone.getText(), email.getText());
            contacts.add(c);
            name.setText("");
            phone.setText("");
            email.setText("");
        }

    }

    public void removeContact() {
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }
}
