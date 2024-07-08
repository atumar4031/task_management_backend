package com.attech.user;

import com.attech.model.BaseEntity;
import com.attech.role.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String password;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

//    public User(Integer id, String status, String firstName, String lastName, String phone, String email, String password, Set<Role> roles) {
//        super(id, status);
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.email = email;
//        this.password = password;
//        this.roles = roles;
//    }

//    public static class UserBuilder extends BaseEntityBuilder{
//        UserBuilder() {
//            super();
//        }
//    }
}