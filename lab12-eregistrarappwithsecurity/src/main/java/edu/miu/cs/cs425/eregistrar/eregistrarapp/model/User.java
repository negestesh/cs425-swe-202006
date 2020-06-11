package edu.miu.cs.cs425.eregistrar.eregistrarapp.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    @NotBlank(message = "*First Name is required")
    private String firstName;

    @Column(nullable = true)
    private String middleName;

    @Column(nullable = false)
    @NotBlank(message = "*Last Name is required")
    private String lastName;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "*Username is required")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "* Password is required")
    @Size(min = 8)
    private String password;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "*E-mail is required")
    @Email(message = "{errors.invalid_email}")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")}
    )
    private List<Role> roles;

    public User() {
    }

    public User(Integer userId, String firstName, String middleName, String lastName, String username, String password, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return String.format(
                "User [firstName=%s, middleName=%s, lastName=%s, username=%s, password=%s, email=%s]",
                this.firstName,
                this.middleName,
                this.lastName,
                this.username,
                this.password,
                this.email);
    }
}
