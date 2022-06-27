package com.example.weatherapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.weatherapp.model.Weather;

public interface WeatherRepository extends JpaRepository<Weather,Long> {


	Weather findByCity(String location);


	


}
