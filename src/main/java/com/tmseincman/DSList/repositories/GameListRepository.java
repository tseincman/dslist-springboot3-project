package com.tmseincman.DSList.repositories;

import com.tmseincman.DSList.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
