package com.example.springdataautomappingobjects_dto.service.impl;

import com.example.springdataautomappingobjects_dto.model.dto.GameAddDto;
import com.example.springdataautomappingobjects_dto.model.entity.Game;
import com.example.springdataautomappingobjects_dto.repository.GameRepository;
import com.example.springdataautomappingobjects_dto.service.GameService;
import com.example.springdataautomappingobjects_dto.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        Set<ConstraintViolation<GameAddDto>> violations =
                validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);

        gameRepository
                .save(game);
        System.out.println("Added game " + gameAddDto.getTitle());
    }

    @Override
    public void editGame(long gameId, BigDecimal price, double size) {

        Game game = gameRepository
                .findById(gameId)
                .orElse(null);

        if (game == null){
            System.out.println("Id is not correct");
            return;
        }

        game.setPrice(price);
        game.setSize(size);

        gameRepository.save(game);

    }

    @Override
    public void deleteDame(long gameId) {
        Game game = gameRepository
                .getById(gameId);
    }
}








