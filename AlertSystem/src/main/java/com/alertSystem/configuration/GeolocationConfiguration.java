package com.alertSystem.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.maps.GeoApiContext;

@Configuration
public class GeolocationConfiguration {

	
	@Value("${geolocation.key}")
	private String geolocationApiKey;
	
	@Bean
	GeoApiContext context()
	{
		GeoApiContext context = new GeoApiContext.Builder().apiKey(geolocationApiKey).build();
		return context;
	}
}
