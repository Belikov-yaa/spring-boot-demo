package ru.geekbrains.springbootdemo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled",
            nullable = false,
            columnDefinition = "TINYINT(1)")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Collection<Role> roles;

    public User() {
    }

//    public User(String userName, String password, String firstName, String lastName, String email) {
//        this.userName = userName;
//        this.password = password;
//
//    }
//
//    public User(String userName, String password, String firstName, String lastName, String email,
//                Collection<Role> roles) {
//        this.userName = userName;
//        this.password = password;
//        this.roles = roles;
//    }
}
