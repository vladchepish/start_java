package ru.stqa.pft.mantis.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "mantis_user_table")
@Table(name = "mantis_user_table")
public class UsersDate {

    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UsersDate{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersDate usersDate = (UsersDate) o;

        if (id != usersDate.id) return false;
        if (username != null ? !username.equals(usersDate.username) : usersDate.username != null) return false;
        return email != null ? email.equals(usersDate.email) : usersDate.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
