package io.github.aenesgur.landroutecalculator.service;

import io.github.aenesgur.landroutecalculator.model.RouteResponse;

public interface LandRouteCalculateService {

    RouteResponse calculate(String origin, String destination);
}
