package com.tmseincman.DSList.services;


import com.tmseincman.DSList.dto.GameDTO;
import com.tmseincman.DSList.dto.GameListDTO;
import com.tmseincman.DSList.dto.GameMinDTO;
import com.tmseincman.DSList.entities.Game;
import com.tmseincman.DSList.entities.GameList;
import com.tmseincman.DSList.projections.GameMinProjection;
import com.tmseincman.DSList.repositories.GameListRepository;
import com.tmseincman.DSList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destionationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destionationIndex, obj);

        int min = sourceIndex < destionationIndex ? sourceIndex : destionationIndex;
        int max = sourceIndex > destionationIndex ? sourceIndex : destionationIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}

