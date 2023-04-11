package com.example.AccesaProject.repository;

import com.example.AccesaProject.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface QuestRepository extends JpaRepository<Quest,Long> {
}
