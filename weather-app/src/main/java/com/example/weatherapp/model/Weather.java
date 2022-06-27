
package com.example.weatherapp.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "weather")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String weatherMain;
	private String description;
	private double temperature;
	private double feelsLike;
	private Integer pressure;
	private Integer humidity;
	private String city;
	public Weather() {

	}

	public Weather(long id, String weatherMain, String description, double temperature, double feelsLike,
			Integer pressure, Integer humidity, String city) {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWeatherMain() {
		return weatherMain;
	}

	public void setWeatherMain(String weatherMain) {
		this.weatherMain = weatherMain;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherMain((String) weather.get("main"));
		setDescription((String) weather.get("description"));
	}

	public double getTemperature() {
		return temperature;
	}

	@JsonProperty("temp")
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getFeelsLike() {
		return feelsLike;
	}

	@JsonProperty("feels_like")
	public void setFeelsLike(double feelsLike) {
		this.feelsLike = feelsLike;
	}

	public Integer getPressure() {
		return pressure;
	}

	@JsonProperty("pressure")
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	@JsonProperty("humidity")
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		setTemperature((double) main.get("temp"));
		setFeelsLike((double) main.get("feels_like"));
		setPressure((Integer) main.get("pressure"));
		setHumidity((Integer) main.get("humidity"));
	}

	public String getCity() {
		return city;
	}

	@JsonProperty("name")
	public void setCity(String city) {
		this.city = city;
	}
	
}
