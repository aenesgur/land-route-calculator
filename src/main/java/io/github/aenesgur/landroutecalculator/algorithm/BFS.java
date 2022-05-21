package io.github.aenesgur.landroutecalculator.algorithm;

import io.github.aenesgur.landroutecalculator.client.Country;
import io.github.aenesgur.landroutecalculator.exception.RouteNotFoundException;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BFS implements Graph {
    private final Map<String, Country> countries;
    private final Country source;
    private final Country target;


    private final Map<Country, Boolean> visitedCountryMap = new HashMap<>();
    private final Map<Country, Country> previousPathMap = new HashMap<>();

    public List<String> run() {

        //BFS uses Queue data structure
        Queue<Country> queue = new LinkedList<>();
        queue.add(source);

        boolean check = false;
        while (!queue.isEmpty()) {
            Country currentCountry = queue.remove();
            visitedCountryMap.put(currentCountry, true);
            if (target.equals(currentCountry)) {
                check = true;
                break;
            }
            for (String borderCountry : currentCountry.getBorders()) {
                var neighbourCountry = countries.get(borderCountry);
                if (!visitedCountryMap.containsKey(neighbourCountry)) {
                    queue.add(neighbourCountry);
                    visitedCountryMap.put(neighbourCountry, true);
                    previousPathMap.put(neighbourCountry, currentCountry);
                    if (neighbourCountry.equals(target)) {
                        check = true;
                        break;
                    }
                }
            }
            if (check) {
                break;
            }
        }

        if (!check) {
            throw new RouteNotFoundException("Route could not be created");
        }

        List<Country> landRoute = new ArrayList<>();
        for (Country country = target; country != null; country = previousPathMap.get(country)) {
            landRoute.add(country);
        }

        Collections.reverse(landRoute);
        return landRoute.stream().map(Country::getCca3).collect(Collectors.toList());
    }
}
