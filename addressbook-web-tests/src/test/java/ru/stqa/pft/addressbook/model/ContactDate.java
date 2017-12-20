package ru.stqa.pft.addressbook.model;

public class ContactDate {
    private final String id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String eMail;
    private String group;

    public ContactDate(String id, String firstName, String middleName, String lastName, String address, String phone, String eMail, String group) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.eMail = eMail;
        this.group = group;
    }

    public ContactDate(String firstName, String middleName, String lastName, String address, String phone, String eMail, String group) {
        this.id = null;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.eMail = eMail;
        this.group = group;
    }

    public String getId() {
        return id;
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

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String geteMail() {
        return eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactDate that = (ContactDate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactDate{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getGroup() {
        return group;
    }
}
