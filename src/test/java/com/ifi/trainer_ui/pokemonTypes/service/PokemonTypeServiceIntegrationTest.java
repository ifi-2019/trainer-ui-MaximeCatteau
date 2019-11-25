package com.ifi.trainer_ui.pokemonTypes.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class PokemonTypeServiceIntegrationTest {

    @Autowired
    PokemonTypeService service;

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void serviceAndTemplateShouldNotBeNull(){
        assertNotNull(restTemplate);
        assertNotNull(service);
    }
}
