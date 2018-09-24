package io.codingchallenge.results;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AbstractMovieInfoWrapper extends AbstractMovieDbWrapper{
	
    @JsonProperty("video")
    private boolean video = false;
    @JsonProperty("title")
    private String title = "";
    @JsonProperty("original_title")
    private String originalTitle = "";
    @JsonProperty("adult")
    private boolean adult = false;
    @JsonProperty("release_date")
    private String releaseDate = "";
	

	public boolean isVideo() {
		return video;
	}
	public void setVideo(boolean video) {
		this.video = video;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public boolean isAdult() {
		return adult;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	} 
    
    
}

/**
 *   	X    "vote_count": 151,
        X    "id": 5879,
        X    "video": false,
        X    "vote_average": 6.5,
        X    "title": "In the Realm of the Senses",
         X   "popularity": 34.383,
        X    "poster_path": "/ztLv3Co2uLZMV7YERWbPrTMUi03.jpg",
        X    "original_language": "ja",
        X    "original_title": "愛のコリーダ",
        X    "genre_ids": [
         X       18,
         X       10749
          X  ],
        X    "backdrop_path": "/rs70IbL9olnQaIoZIIMkQo7CtVG.jpg",
            "adult": false,
            "overview": "Based on a true story set in pre-war Japan, a man and one of his servants begin a torrid affair. Their desire becomes a sexual obsession so strong that to intensify their ardor, they forsake all, even life itself.",
            "release_date": "1976-05-15"
**/


/**
 * Common variables:
 * 
 * 	id
 *  vote_count
 *  vote_average
 *  popularity
 *  poster_path
 * genre_ids
 * original_language
 * backdrop_path
 * overview
 */


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
