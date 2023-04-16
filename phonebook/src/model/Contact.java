package model;

import java.io.Serializable;
import java.util.Comparator;

public class Contact implements Serializable , Comparator<Contact> {
private String name;
private String phonenumber;
private Type type;

    public Contact() {
    }

    public Contact(String name, String phonenumber, Type type) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", type=" + type +
                '}';
    }
  @Override
   public int compare(Contact contact1, Contact contact2){
        return contact1.getName().compareToIgnoreCase(contact2.getName());
   }
}
