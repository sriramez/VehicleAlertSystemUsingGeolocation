package com.alertSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.AddressType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

@Service
public class GeolocationService {

	@Autowired
	GeoApiContext context;
	
	public String getCityNameFromLatitudeAndLongitude(double latitude,double longitude)
	{
		LatLng position = new LatLng(latitude, longitude);
		GeocodingResult[] results = null;
		try {
		results =  GeocodingApi.newRequest(context)
		        .latlng(position ).language("en").resultType(AddressType.LOCALITY, AddressType.ADMINISTRATIVE_AREA_LEVEL_1).await();
		}
		catch (Exception e) {

		}
		String cityName ="invalid";
		if(results.length>0)
		{
			GeocodingResult result = results[0];
			boolean cityloaded = false;
			for(AddressComponent component : result.addressComponents)
			{
				if(cityloaded==true)
				{
					break;
				}
				for(AddressComponentType type : component.types)
				{
					if(type==AddressComponentType.LOCALITY);
					cityName = component.longName;
					cityloaded = true;
					break;
				}
			}
		}
		return cityName;
	}
	
}
