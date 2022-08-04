package ru.Mol.Enum;

public enum RequestCode {
    JSONINCORRECT("JSON type or classes incorrect. Expected: {\n" +
            "  \"client\": {\n" +
            "    \"name\": \"clientName\",\n" +
            "    \"surname\": \"clientSurname\",\n" +
            "    \"patronymic\": \"clientPatronymic\",\n" +
            "    \"login\": \"clientLogin\",\n" +
            "    \"passportSeries\": \"****\",\n" +
            "    \"passportNumber\": \"*******\"\n" +
            "  },\n" +
            "  \"contactData\": {\n" +
            "    \"phoneNumber\": \"clientNumber\",\n" +
            "    \"mail\": \"clientMail\"\n" +
            "  }\n" +
            "}"),UNEXPECTEDERROR("Unexpected error on server side"),
    CLIENTISNOTSAVED("Client is not save in csv file"),OK("Client successfully saved");

    private final String responseText;
    private RequestCode(final String responseText) { this.responseText = responseText; }



    public String getResponseText() { return this.responseText; }
}
