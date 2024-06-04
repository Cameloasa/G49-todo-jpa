package se.lexicon.g49todojpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "creationDate")

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType type;

    @Column(nullable = false)
    private LocalDateTime creationDate=LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
