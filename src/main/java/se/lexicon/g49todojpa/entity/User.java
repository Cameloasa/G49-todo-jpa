package se.lexicon.g49todojpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString(exclude = "password")

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;


    @Column(nullable = false)
    private String userName;


    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate creationDate = LocalDate.now();

    @OneToMany(mappedBy = "type")
    private Set<Role> roles;

    public void addRole(Role role) {
        roles.add(role);
        role.setUser(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.setUser(null);
    }
}
