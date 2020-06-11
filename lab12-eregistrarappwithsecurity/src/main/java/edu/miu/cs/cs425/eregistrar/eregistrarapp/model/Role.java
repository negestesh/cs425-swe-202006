package edu.miu.cs.cs425.eregistrar.eregistrarapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String name;


    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
    }

    public Role(Integer roleId, String name){
        this.roleId = roleId;
        this.name = name;
    }


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return String.format(
                "Role [name=%s]",
                this.name);
    }
}
