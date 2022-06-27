package com.example.weatherapp.service;


import com.example.weatherapp.model.Weather;


public interface WeatherService {
	
	
	Weather getWeather(String location);
}
