package com.example.weatherapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.example.weatherapp.model.Weather;
import com.example.weatherapp.model.WeatherAPI;
import com.example.weatherapp.repository.WeatherRepository;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	public RestTemplate restTemplate;

	@Autowired
	WeatherAPI weatherAPI;

	private WeatherRepository weatherRepository;

	public WeatherServiceImpl(WeatherRepository weatherRepository) {
		super();
		this.weatherRepository = weatherRepository;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public Weather getWeather(String city) {
		Weather existingWeather = weatherRepository.findByCity(city);
		if (existingWeather == null) {
			String url = weatherAPI.getUrl() + city + weatherAPI.getExtra() + weatherAPI.getKey();
			try {
				Weather response = restTemplate.getForObject(url, Weather.class);
				weatherRepository.save(response);
				return response;

			} catch (HttpStatusCodeException exception) {
				//int statusCode = exception.getStatusCode().value();
				String resp = exception.getResponseBodyAsString();
				System.out.println(resp);
			}

		}
		return existingWeather;
	}
}
