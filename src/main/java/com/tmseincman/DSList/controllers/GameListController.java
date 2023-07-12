package com.tmseincman.DSList.controllers;

import com.tmseincman.DSList.dto.GameDTO;
import com.tmseincman.DSList.dto.GameListDTO;
import com.tmseincman.DSList.dto.GameMinDTO;
import com.tmseincman.DSList.services.GameListService;
import com.tmseincman.DSList.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;

    }


}
