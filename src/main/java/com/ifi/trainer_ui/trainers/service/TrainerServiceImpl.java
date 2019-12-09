package com.ifi.trainer_ui.trainers.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeServiceImpl;
import com.ifi.trainer_ui.trainers.bo.Pokemon;
import com.ifi.trainer_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private String trainerServiceUrl;
    private String pokemonTypeServiceUrl;
    private RestTemplate restTemplate;

    @Override
    public List<Trainer> listTrainers() {
        Trainer[] result = restTemplate.getForObject(trainerServiceUrl, Trainer[].class);

        for(Trainer t : result){
            t.setRealTeam(getTrainerRealTeam(t));
        }

        return Arrays.asList(result);
    }

    public List<PokemonType> listPokemonTypes(){
        PokemonType[] pokemons = restTemplate.getForObject(pokemonTypeServiceUrl, PokemonType[].class);

        return Arrays.asList(pokemons);
    }

    @Override
    public Trainer getTrainer(String name) {
        Trainer[] trainers = restTemplate.getForObject(trainerServiceUrl, Trainer[].class);
        Trainer result = null;

        for(Trainer t : trainers){
            if(t.getName().equals(name)){
                result = t;
            }
        }

        return result;
    }

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    public void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value(value = "${trainer.service.url}/trainers/")
    public void setTrainerServiceUrl(String url){
        this.trainerServiceUrl = url;
    }

    @Value(value = "${pokemonType.service.url}/pokemon-types/")
    public void setPokemonTypeServiceUrl(String url){
        this.pokemonTypeServiceUrl = url;
    }

    public List<PokemonType> getTrainerRealTeam(Trainer t){
        List<PokemonType> realTeam = new ArrayList<PokemonType>();
        List<Pokemon> trainerTeam = t.getTeam();

        for(Pokemon p : trainerTeam){
            for(PokemonType pt : listPokemonTypes()){
                if(pt.getId() == p.getPokemonType()){
                    pt.setLevel(p.getLevel());
                    realTeam.add(pt);
                }
            }
        }

        return realTeam;
    }
}
