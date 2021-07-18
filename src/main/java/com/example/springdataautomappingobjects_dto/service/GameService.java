package com.example.springdataautomappingobjects_dto.service;

import com.example.springdataautomappingobjects_dto.model.dto.GameAddDto;

import java.math.BigDecimal;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(long parseLong, BigDecimal bigDecimal, double parseDouble);

    void deleteDame(long parseLong);
}
