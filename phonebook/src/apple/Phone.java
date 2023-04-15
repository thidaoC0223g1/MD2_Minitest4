package apple;

import model.Contact;
import model.Type;

public abstract class Phone {
    public abstract void display(Type type);

    public abstract void insertPhone(Contact contact);

    public abstract void removePhone(String name);

    public abstract void updatePhone(String phone, String newphone);
}
