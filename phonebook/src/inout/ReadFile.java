package inout;


import model.Contact;

import java.io.*;
import java.util.List;

public class ReadFile {
    public List<Contact> readContact() {
        File file = new File("./phonebook/txt/phonebook.dat");
        List<Contact> contactlist;
        try {
            FileInputStream fileinput = new FileInputStream(file);
            ObjectInputStream listinput = new ObjectInputStream(fileinput);
             contactlist = (List<Contact>) listinput.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
           return contactlist;
    }

}
