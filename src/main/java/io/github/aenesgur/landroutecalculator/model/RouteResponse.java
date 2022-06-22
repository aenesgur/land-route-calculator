package io.github.aenesgur.landroutecalculator.model;

import lombok.Data;

import java.util.List;

@Data
public class RouteResponse extends BaseResponse{
    private List<String> route;
}
