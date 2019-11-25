package com.ifi.trainer_ui.trainers.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.trainers.bo.Pokemon;
import com.ifi.trainer_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private String trainerServiceUrl;
    private RestTemplate restTemplate;

    @Override
    public List<Trainer> listTrainers() {
        Trainer[] result = restTemplate.getForObject(trainerServiceUrl, Trainer[].class);

        // Setting the real team

        return Arrays.asList(result);
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value(value = "${trainer.service.url}/trainers/")
    public void setTrainerServiceUrl(String url){
        this.trainerServiceUrl = url;
    }
}
