package control;

import apple.Iphone;
import apple.Phone;
import inout.ReadFile;
import inout.WriteFile;
import model.Contact;
import model.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookManager extends Phone implements Iphone {
    private List<Contact> contactList = new ArrayList<>();

    public PhoneBookManager() {
    }

    public PhoneBookManager(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public void searchPhone(String name) {
        ReadFile readfile = new ReadFile();
        List<Contact> contactList= readfile.readContact();
        contactList.stream().filter(contact -> name.equals(contact.getName())).forEach(System.out::println);
    }

    @Override
    public void sort() {


    }

    @Override
    public void display(Type type) {

    }

    @Override
    public void insertPhone(Contact contact) {
        ReadFile readfile = new ReadFile();
        List<Contact> contactList= readfile.readContact();
        WriteFile writeFile = new WriteFile();
        contactList.add(contact);
        writeFile.writeContact(contactList);

    }

    @Override
    public void removePhone(String name) {
        ReadFile readfile = new ReadFile();
        List<Contact> contactList= readfile.readContact();
        contactList.removeIf(contact -> name.equals(contact.getName()));
        WriteFile writeFile = new WriteFile();
        writeFile.writeContact(contactList);

    }

    @Override
    public void updatePhone(String phone, String newphone) {

    }


    public Contact getNewContact() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap vao ho ten");
        String name = input.nextLine();
        System.out.println("Nhap vao so dien thoai");
        String phonenumber = input.nextLine();
        Type type = new Type(0, " ", " ");
        System.out.println("An phim 1 de chon kieu tuy chon \n" +
                "An phim bat ki de chon kieu mac dinh");
        String choice = input.nextLine();
        if (choice.equals("1")) {
            System.out.println("nhap vao id");
            String id = input.nextLine();
            type.setId(Integer.parseInt(id));
            System.out.println("nhap vao ten cong ty");
            String companyname = input.nextLine();
            type.setCompanyname(companyname);
            System.out.println("nhap vao dia chi");
            String address = input.nextLine();
            type.setAddress(address);
        } else {
            System.out.println("kieu mac dinh se duoc su dung");
        }

        Contact contact = new Contact(name, phonenumber, type);
        return contact;
    }

}
