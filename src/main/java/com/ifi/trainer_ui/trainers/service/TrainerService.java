package com.ifi.trainer_ui.trainers.service;

import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.trainers.bo.Trainer;

import java.util.List;

public interface TrainerService {
    public List<Trainer> listTrainers();
    Trainer getTrainer(String name);
    public List<Trainer> getAllTrainers();
}
