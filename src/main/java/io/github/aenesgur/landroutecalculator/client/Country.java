package io.github.aenesgur.landroutecalculator.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private String cca3;
    private List<String> borders;
}
