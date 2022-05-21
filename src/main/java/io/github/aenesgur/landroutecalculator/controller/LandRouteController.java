package io.github.aenesgur.landroutecalculator.controller;

import io.github.aenesgur.landroutecalculator.service.LandRouteCalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LandRouteController {

    private final LandRouteCalculateService landRouteCalculateService;

    @GetMapping("/routes/{origin}/{destination}")
    public ResponseEntity calculateLandRoute(@PathVariable("origin") String origin,
                                             @PathVariable("destination") String destination) {

       return new ResponseEntity<>(landRouteCalculateService.calculate(origin,destination), HttpStatus.OK);
    }
}
