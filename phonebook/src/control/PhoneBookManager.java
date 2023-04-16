package control;

import apple.Iphone;
import apple.Phone;
import inout.ReadFile;
import inout.WriteFile;
import model.Contact;
import model.Type;

import java.util.*;

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
        boolean check =false;
        for(Contact contact:contactList){
            if(name.equals(contact.getName())){
                System.out.println("danh ba can tim la "+ contact.getName()+" "+ contact.getPhonenumber());
                check=true;
                break;
            }
        }if(!check){
            System.out.println("ten can tim chua co trong danh ba");
        }
    }

    @Override
    public void sort() {
        ReadFile readfile = new ReadFile();
        List<Contact> contactList= readfile.readContact();
        contactList.sort(new Contact());
        WriteFile writeFile = new WriteFile();
        writeFile.writeContact(contactList);
    }

    @Override
    public void display(Type type) {
        ReadFile readfile = new ReadFile();
        List<Contact> contactList= readfile.readContact();
        for(Contact contact :contactList){
            if(type ==null){
                System.out.println(contact);
            }else if (type.getId()==contact.getType().getId()&&type.getCompanyname().equals(contact.getType().getCompanyname())
            && type.getAddress().equals(contact.getType().getAddress())){
                System.out.println("danh ba can tim la "+ contact.getName()+" "+ contact.getPhonenumber());
            }
        }
    }

    @Override
    public void insertPhone(Contact contact) {
        ReadFile readfile = new ReadFile();
        List<Contact> contactList= readfile.readContact();
        contactList.add(contact);
        WriteFile writeFile = new WriteFile();
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
    public void updatePhone(String name, String newphone) {
        ReadFile readfile = new ReadFile();
        List<Contact> contactList= readfile.readContact();
      for(Contact contact:contactList){
          if(name.equals(contact.getName())){
              contact.setPhonenumber(newphone);
          }
      }
        WriteFile writeFile = new WriteFile();
        writeFile.writeContact(contactList);
    }


    public Contact getNewContact() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap vao ho ten");
        String name = input.nextLine();
        System.out.println("Nhap vao so dien thoai");
        String phonenumber = input.nextLine();
        Type type = new Type(0, "", "");
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
