package io.github.aenesgur.landroutecalculator.algorithm;

import io.github.aenesgur.landroutecalculator.client.Country;
import io.github.aenesgur.landroutecalculator.exception.RouteNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


class BFSTest {
    private final Map<String, Country> countryMap;
    BFSTest(){
        countryMap = new HashMap<>();
        countryMap.put("ITA", new Country("ITA", List.of("AUT","FRA","SMR","SVN","CHE","VAT")));
        countryMap.put("FRA", new Country("FRA", List.of("DEN","BEN","CEN")));
        countryMap.put("CZE", new Country("CZE", List.of("AUT","DEU","POL","SVK")));
        countryMap.put("AUT", new Country("AUT", List.of("CZE","DEU","HUN","ITA","LIE","SVK","SVN","CHE")));

    }

    @Test
    public void run_methodExecute_shouldCreateRoute(){
        Country currentCountry = countryMap.get("CZE");
        Country targetCountry = countryMap.get("ITA");

        Graph graph = new BFS(countryMap, currentCountry, targetCountry);
        List<String> actualLandRoute = graph.run();
        List<String> expectedLandRoute = List.of("CZE","AUT", "ITA");

        Assertions.assertTrue(expectedLandRoute.equals(actualLandRoute));
    }

    @Test
    public void run_methodCouldNotExecute_routeCouldNotBeCreated(){
        Country currentCountry = countryMap.get("CZE");
        Country targetCountry = countryMap.get("ITA");

        Graph graph = new BFS(countryMap, currentCountry, targetCountry);

        try {
            List<String> actualLandRoute = graph.run();
        }catch(RouteNotFoundException ex){
            Assertions.assertEquals(ex.getMessage(), "Route could not be created");
        }
    }
}