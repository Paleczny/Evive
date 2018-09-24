package io.codingchallenge.results;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbstractTvInfoWrapper extends  AbstractMovieDbWrapper {

	@JsonProperty("original_name")
	private String originalName = "";
	@JsonProperty("name")
	private String name = "";
	@JsonProperty("first_air_date")
	private String firstAirDate = "";
	@JsonProperty("origin_country")
	private ArrayList<String> originCountrys = new ArrayList();
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstAirDate() {
		return firstAirDate;
	}
	public void setFirstAirDate(String firstAirDate) {
		this.firstAirDate = firstAirDate;
	}
	public ArrayList<String> getOriginCountrys() {
		return originCountrys;
	}
	public void setOriginCountryS(ArrayList<String> originCountrys) {
		this.originCountrys = originCountrys;
	}
	
}



/**
 *    "original_name": "Arrow",
            "id": 1412,
            "name": "Arrow",
            "popularity": 54.655,
            "vote_count": 1939,
            "vote_average": 6,
            "first_air_date": "2012-10-10",
            "poster_path": "/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
            "genre_ids": [
                80,
                18,
                9648,
                10759
            ],
            "original_language": "en",
            "backdrop_path": "/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg",
            "overview": "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "origin_country": [
                "US"
            ]
            **/ 