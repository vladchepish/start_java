package ru.stqa.pft.adrbook;

public class ContactDate {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String homePhone;
    private final String frstEmail;

    public ContactDate(String firstName, String middleName, String LastName, String homePhone, String frstEmail) {
        this.firstName = firstName;
        this.middleName = middleName;
        lastName = LastName;
        this.homePhone = homePhone;
        this.frstEmail = frstEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getFrstEmail() {
        return frstEmail;
    }
}
