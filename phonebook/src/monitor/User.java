package monitor;

import control.PhoneBookManager;
import inout.ReadFile;
import model.Contact;
import model.Type;

import java.util.List;
import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        System.out.println("Contact Menu");
        System.out.println("Press 1: insert new contact");
        System.out.println("Press 2: search contact by name");
        System.out.println("Press 3: display contact by type");
        System.out.println("Press 4: remove contact by name");
        System.out.println("Press 5: sort contact by alphabet");
        System.out.println("Press 0: move out of contact");
        PhoneBookManager manager = new PhoneBookManager();
        while (true) {
            System.out.println("enter your choise");
            Scanner input = new Scanner(System.in);
            String inputchoice = input.nextLine();
            int choise = Integer.parseInt(inputchoice);
            switch (choise) {
                case 1:
                    manager.insertPhone(manager.getNewContact());
                    break;
                case 2:
                    System.out.println("enter the name you want to find");
                    String name = input.nextLine();
                    manager.searchPhone(name);
                    break;
                case 3:
                    System.out.println("enter your choice to display");
                    System.out.println("press 1 to display all contact");
                    System.out.println("press 2 to display by specified type");
                    String inputchoicedisplay = input.nextLine();
                    int choisedisplay = Integer.parseInt(inputchoicedisplay);
                    switch (choisedisplay) {
                        case 1:
                            manager.display(null);
                            break;
                        case 2:
                            System.out.println("enter your id");
                            String inputid= input.nextLine();
                            int id= Integer.parseInt(inputid);
                            System.out.println("enter your company name");
                            String companyname = input.nextLine();
                            System.out.println("enter your address");
                            String address = input.nextLine();
                            Type type = new Type(id,companyname,address);
                            manager.display(type);
                            break;
                    }break;
                case 4:
                    System.out.println("enter name you wanna remove");
                    String nameremove = input.nextLine();
                    manager.removePhone(nameremove);
                    break;
                case 5:
                    manager.sort();
                    break;
                case 0:
                    System.err.println("Exit program");
                    System.exit(0);
            }

        }

    }

}
