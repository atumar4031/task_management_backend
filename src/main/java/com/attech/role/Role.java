package com.attech.role;

import com.attech.model.BaseEntity;
import com.attech.user.User;
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
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

//    @Builder
//    public Role(Integer id, String status, UserRole role, String description, Set<User> users) {
//        super(id, status);
//        this.role = role;
//        this.description = description;
//        this.users = users;
//    }
//
//    public static class RoleBuilder extends BaseEntityBuilder{
//        RoleBuilder() {
//            super();
//        }
//    }
}
