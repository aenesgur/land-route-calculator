package io.github.aenesgur.landroutecalculator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="${api.country.name}", url="${api.country.url}")
public interface CountryApiClient {

	@GetMapping(path = "/master/countries.json")
	List<Country> fetchCountries();
}