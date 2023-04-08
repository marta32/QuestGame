package com.example.AccesaProject.entity;

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
@Table(name = "quests")
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String quest;
    @Column
    private Integer tokens;
    @Column
    private String status;
    @ManyToOne
    private User proposedByUser;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "quest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answerList = new ArrayList<>();
}
