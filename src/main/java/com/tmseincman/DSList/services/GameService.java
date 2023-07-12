package com.tmseincman.DSList.services;


import com.tmseincman.DSList.dto.GameDTO;
import com.tmseincman.DSList.dto.GameMinDTO;
import com.tmseincman.DSList.entities.Game;
import com.tmseincman.DSList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameDTO findByID(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }
}

