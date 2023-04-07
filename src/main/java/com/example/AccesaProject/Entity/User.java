package com.example.AccesaProject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private Integer tokens;
    @Column
    private String password;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Quest> proposedQuests = new ArrayList<Quest>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")
    private List<Quest> resolvedQuests = new ArrayList<Quest>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")
    private List<Badge> badgeList = new ArrayList<Badge>();
}
