package ru.Mol.DataJSONClases;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactData {
    private String phoneNumber;
    private String mail;
    @JsonCreator
    public ContactData(@JsonProperty("phoneNumber")String phoneNumber, @JsonProperty("mail")String mail) {
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



    @Override
    public String toString() {
        return "ContactData{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}