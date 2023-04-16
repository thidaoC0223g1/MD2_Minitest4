package inout;

import model.Contact;

import java.io.*;
import java.util.List;

public class WriteFile {
    public void writeContact(List<Contact> contactList) {
        File file = new File("./phonebook/txt/phonebook.dat");
        try {
            FileOutputStream fileoutput = new FileOutputStream(file);
            try {
                ObjectOutputStream listouput = new ObjectOutputStream(fileoutput);
                listouput.writeObject(contactList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
