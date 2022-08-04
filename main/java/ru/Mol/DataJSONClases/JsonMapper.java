package ru.Mol.DataJSONClases;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonMapper {
    private Client client;
    private ContactData contactData;

    public Client getClient() {
        return client;
    }

    public ContactData getContactData() {
        return contactData;
    }

    @JsonCreator
    public JsonMapper(@JsonProperty("client")Client client, @JsonProperty("contactData")ContactData contactData) {
        this.client = client;
        this.contactData = contactData;
    }

    @Override
    public String toString() {
        return "JsonMapper{" +
                "client=" + client.toString() +
                ", contactData=" + contactData.toString() +
                '}';
    }
}
