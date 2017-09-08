package com.tocsyk.models;


import org.springframework.util.StringUtils;

public class Contact {

    public Contact(String mobile, String telephone, String email, Address address) {
        try {
            setContactID();
            this.Mobile = mobile;
            this.Telephone = telephone;
            this.Email = email;
            this.AddressContact = address;
            this.ContactID = ContactID;
        } catch (IllegalArgumentException aa) {
            System.out.println("Exception has been thrown:" + aa.toString());
            throw aa;
        }
    }


    private String Email;
    private String Telephone;
    private int ContactID;
    private String Mobile;
    private Address AddressContact;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            throw new IllegalArgumentException("Email");
        } else
            Email = email;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        if (StringUtils.isEmpty(telephone)) {
            throw new IllegalArgumentException("Telephone");
        } else
            Telephone = telephone;
    }

    public int getContactID() {
        return ContactID;
    }

    private void setContactID() {
        ContactID = Sequence.getContactSeq();
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            throw new IllegalArgumentException("Mobile");
        } else
            Mobile = mobile;
    }

    public Address getAddressContact() {
        return AddressContact;
    }

    public void setAddressContact(Address addressContact) {
        AddressContact = addressContact;
    }


        /*
        public bool IsNull()
        {
            return ContactID == 0;
        }
        public virtual String GetContactData()
        {
            return
                $"Address is: {this.AddressContact.ToString()}  Email:{this.Email}  Telephone:{this.Telephone} Mobile:{this.Mobile} ";
        }*/

}