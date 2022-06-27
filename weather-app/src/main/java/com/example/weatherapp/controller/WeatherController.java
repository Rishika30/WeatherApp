package com.example.weatherapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherapp.model.Weather;
import com.example.weatherapp.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	private WeatherService weatherService;
	
	public WeatherController(WeatherService weatherService) {
		super();
		this.weatherService= weatherService;
	}
	
	@GetMapping("{location}")
	public ResponseEntity<Weather> getWeather(@PathVariable("location") String location) {
		return new ResponseEntity<Weather>(weatherService.getWeather(location), HttpStatus.OK);
	}
}
