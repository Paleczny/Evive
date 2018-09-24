package io.codingchallenge.tools;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MovieApiUrl {
	//http://api.themoviedb.org/3/discover/movie?release_date.gte=2017-07-01&release_date.lte=2017-07-31&api_key=606aaffd7ca10f0b80804a1f0674e4e1&page=2
	private static final String M_API_BASE = "http://api.themoviedb.org/3/";	
	private static final String M_API_MOVIE = "discover/movie?";
//    private static final String M_API_MOVIE_CREDITS ="movie/{movie_id}/credits?";
    private static final String M_API_MOVIE_CREDITS ="movie/%s/credits?";
	private static final String M_API_TVSHOW = "discover/tv?";
	private static final String M_API_TVSHOW_CREDITS ="tv/%s/credits?";
	private final String API_KEY = "606aaffd7ca10f0b80804a1f0674e4e1";
	
	
	public URL buildMovieUrl(final  HashMap<String, String>  params) 
	{
        StringBuilder urlString = new StringBuilder(M_API_BASE);
        urlString.append(M_API_MOVIE);
        
        for(Map.Entry<String, String>  param:params.entrySet()){
        	urlString.append(param.getKey() + "=" + param.getValue() + "&");
        }
        
        urlString.append("api_key=" +  API_KEY);
        
        try {
            return new URL(urlString.toString());
        } catch (MalformedURLException ex) {
            return null;
        }
		
	}
	
	public URL buildTvUrl(final  HashMap<String, String>  params) 
	{
        StringBuilder urlString = new StringBuilder(M_API_BASE);
        urlString.append(M_API_TVSHOW);
        
        for(Map.Entry<String, String>  param:params.entrySet()){
        	urlString.append(param.getKey() + "=" + param.getValue() + "&");
        }
        
        urlString.append("api_key=" +  API_KEY);
        
        try {
            return new URL(urlString.toString());
        } catch (MalformedURLException ex) {
            return null;
        }
		
	}
	
	public URL buildTvCreditsUrl(String tvShowId) 
	{
        StringBuilder urlString = new StringBuilder(M_API_BASE);
        urlString.append(String.format(M_API_TVSHOW_CREDITS,tvShowId));
        urlString.append("api_key=" +  API_KEY);
        
        try {
            return new URL(urlString.toString());
        } catch (MalformedURLException ex) {
            return null;
        }
		
	}
	

	public URL buildMovieCreditsUrl(String movieId) 
	{
        StringBuilder urlString = new StringBuilder(M_API_BASE);
        urlString.append(String.format(M_API_MOVIE_CREDITS,movieId));
        urlString.append("api_key=" +  API_KEY);
        
        try {
            return new URL(urlString.toString());
        } catch (MalformedURLException ex) {
            return null;
        }
		
	}
	
	

       

}
