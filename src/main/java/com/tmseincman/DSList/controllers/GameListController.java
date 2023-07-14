package com.tmseincman.DSList.controllers;

import com.tmseincman.DSList.dto.GameDTO;
import com.tmseincman.DSList.dto.GameListDTO;
import com.tmseincman.DSList.dto.GameMinDTO;
import com.tmseincman.DSList.dto.ReplacementDTO;
import com.tmseincman.DSList.services.GameListService;
import com.tmseincman.DSList.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;

    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;

    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestionationIndex());

    }


}
