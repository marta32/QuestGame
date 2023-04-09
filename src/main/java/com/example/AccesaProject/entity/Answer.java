package com.example.AccesaProject.entity;

import com.example.AccesaProject.utils.AnswerStatus;
import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Quest quest;
    @Column
    private String questAnswer;
    @Column
    @Enumerated(EnumType.STRING)
    private AnswerStatus status;
}
