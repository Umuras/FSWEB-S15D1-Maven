package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts = new ArrayList<>();

    public MobilePhone(String myNumber, List<Contact> myContacts)
    {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber()
    {
        return myNumber;
    }

    public List<Contact> getMyContacts()
    {
        return myContacts;
    }

    public boolean addNewContact(Contact contact)
    {
        if(myContacts.contains(contact))
        {
            return false;
        }else{
            myContacts.add(contact);
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact)
    {
        if(myContacts.contains(oldContact))
        {
            myContacts.set(myContacts.indexOf(oldContact),newContact);
            return true;
        }else{
            return false;
        }
    }

    public boolean removeContact(Contact contact)
    {
        int index = findContact(contact.getName());
        if(index != -1)
        {
          myContacts.remove(index);
          return true;
        }
        return false;

    }

    public int findContact(Contact contact)
    {
        for (Contact contactItem: myContacts)
        {
            if(contactItem.getName().equals(contact.getName()))
            {
                return myContacts.indexOf(contactItem);
            }
        }
        return -1;
    }

    public int findContact(String contactName)
    {
        for (Contact contact: myContacts)
        {
            if(contact.getName().equals(contactName))
            {
                return myContacts.indexOf(contact);
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName)
    {
        int index = findContact(contactName);
        if(index != -1)
        {
            return myContacts.get(index);
        }

        return null;

    }



    public void printContact()
    {
        for (Contact contact : myContacts)
        {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }


}
