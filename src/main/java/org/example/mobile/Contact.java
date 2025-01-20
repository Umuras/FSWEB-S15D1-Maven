package org.example.mobile;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public String getName()
    {
        return name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber)
    {
        return new Contact(name, phoneNumber);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }

        return ((Contact)obj).getName().equals(this.getName()) && ((Contact)obj).getPhoneNumber().equals(this.getPhoneNumber());
    }


}
