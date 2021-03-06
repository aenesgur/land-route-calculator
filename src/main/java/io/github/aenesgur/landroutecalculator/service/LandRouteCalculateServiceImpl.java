package io.github.aenesgur.landroutecalculator.service;

import io.github.aenesgur.landroutecalculator.algorithm.BFS;
import io.github.aenesgur.landroutecalculator.algorithm.Graph;
import io.github.aenesgur.landroutecalculator.client.CountryApiClient;
import io.github.aenesgur.landroutecalculator.client.Country;
import io.github.aenesgur.landroutecalculator.exception.RouteNotFoundException;
import io.github.aenesgur.landroutecalculator.model.RouteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LandRouteCalculateServiceImpl implements LandRouteCalculateService{

    private final CountryApiClient countryApiClient;
    @Override
    public RouteResponse calculate(String currentCode, String targetCode) {
        List<Country> countries =  countryApiClient.fetchCountries();
        Map<String, Country> countryMap = countries.stream()
                .collect(Collectors.toMap(Country::getCca3, Function.identity()));
        Country currentCountry = countryMap.get(currentCode);
        Country targetCountry = countryMap.get(targetCode);
        validate(currentCountry, targetCountry, currentCode, targetCode);

        Graph graph = new BFS(countryMap, currentCountry, targetCountry);
        List<String> route = graph.run();

        RouteResponse routeResponse = new RouteResponse();
        routeResponse.setRoute(route);

        return routeResponse;
    }

    private void validate(Country currentCountry, Country targetCountry,String currentCode, String targetCode){
        if(currentCode.equals(targetCode)){
            throw new RouteNotFoundException("Current and target country codes are equal");
        }
        if (currentCountry == null){
            throw new RouteNotFoundException("Current country could not found in JSON");
        }
        if (targetCountry == null){
            throw new RouteNotFoundException("Target country could not found in JSON");
        }
        if (currentCountry.getBorders().isEmpty()) {
            throw new RouteNotFoundException("Current country's borders are empty");
        }
        if (targetCountry.getBorders().isEmpty()) {
            throw new RouteNotFoundException("Target country's borders are empty");
        }
    }
}
