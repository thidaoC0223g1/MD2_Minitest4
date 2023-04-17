package inout;


import model.Contact;

import java.io.*;
import java.util.List;

public class ReadFile<T> {
    public List<T> readContact() {
        File file = new File("./phonebook/txt/phonebook.dat");
        List<T> contactlist;
        try {
            FileInputStream fileinput = new FileInputStream(file);
            ObjectInputStream listinput = new ObjectInputStream(fileinput);
             contactlist = (List<T>) listinput.readObject();
             listinput.close();
             fileinput.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
           return (List<T>) contactlist;
    }

}
