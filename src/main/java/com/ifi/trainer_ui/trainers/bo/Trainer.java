package com.ifi.trainer_ui.trainers.bo;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;

import java.util.List;

public class Trainer {
    private String name;

    private List<Pokemon> team;

    private List<PokemonType> realTeam;

    public Trainer(){

    }

    public Trainer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }

    public List<PokemonType> getRealTeam(){
        return realTeam;
    }

    public void setRealTeam(List<PokemonType> realTeam){
        this.realTeam = realTeam;
    }
}
