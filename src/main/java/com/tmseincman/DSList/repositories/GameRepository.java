package com.tmseincman.DSList.repositories;

import com.tmseincman.DSList.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}