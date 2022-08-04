package ru.Mol.DataCSVClasses;

import ru.Mol.DataJSONClases.Client;
import ru.Mol.DataJSONClases.ContactData;
import ru.Mol.DataJSONClases.JsonMapper;

public class ClientDBData implements CSVConvertable {
    public ClientDBData(JsonMapper jsonMapper) {
        this.name = jsonMapper.getClient().getName();
        this.surname = jsonMapper.getClient().getSurname();
        this.patronymic = jsonMapper.getClient().getPatronymic();
        this.login = jsonMapper.getClient().getLogin();
        this.passportSeries = jsonMapper.getClient().getPassportSeries();
        this.passportNumber = jsonMapper.getClient().getPassportNumber();
        this.phoneNumber = jsonMapper.getContactData().getPhoneNumber();
        this.mail = jsonMapper.getContactData().getMail();
    }

    private String name;
    private String surname;
    private String patronymic;
    private String login;
    private String passportSeries;
    private String passportNumber;
    private String phoneNumber;
    private String mail;



    @Override
    public String convertToCSV() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(",");
        stringBuilder.append(surname);
        stringBuilder.append(",");
        stringBuilder.append(patronymic);
        stringBuilder.append(",");
        stringBuilder.append(login);
        stringBuilder.append(",");
        stringBuilder.append(passportSeries);
        stringBuilder.append(",");
        stringBuilder.append(passportNumber);
        stringBuilder.append(",");
        stringBuilder.append(phoneNumber);
        stringBuilder.append(",");
        stringBuilder.append(mail);
        return stringBuilder.toString();
    }
}