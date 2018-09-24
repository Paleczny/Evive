package io.codingchallenge.controller;

import io.codingchallenge.app.EviveApp;
import io.codingchallenge.results.AbstractMovieInfoWrapper;
import io.codingchallenge.results.AbstractMovieResultsWrapper;
import io.codingchallenge.results.AbstractTvInfoWrapper;
import io.codingchallenge.results.AbstractTvResultsWrapper;
import io.codingchallenge.results.CreditsInfoWrapper;
import io.codingchallenge.results.MovieCreditsInfoWrapper;
import io.codingchallenge.results.TvCastWrapper;
import io.codingchallenge.tools.MovieApiUrl;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(EviveApp.class);	
	//TheMovieDB API current limits are 40 requests every 10 seconds and are limited by IP address, not API key. 
	//You can think of this is being burstable to 40 in a single second, or as an average of 4 requests/second. 
	
	public ArrayList<AbstractMovieInfoWrapper> getAllMoviesPagesBetweenDates(String release_date_from, String release_date_to) throws RestClientException, URISyntaxException, InterruptedException {
		HashMap<String, String> variables = new HashMap<String, String>();
		variables.put("release_date.gte", release_date_from);
		variables.put("release_date.lte", release_date_to);
		variables.put("page","1");
		
		URL url = new MovieApiUrl().buildMovieUrl(variables);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<AbstractMovieResultsWrapper> response = restTemplate.getForEntity(
				url.toURI(), AbstractMovieResultsWrapper.class);
		
		int totalPages = response.getBody().getTotalPages();
		ArrayList<AbstractMovieInfoWrapper> allMoviePages = new ArrayList();
		logger.info("total movie pages: " + totalPages);
		int i = 1;
		while(i <= totalPages){
			try{
				allMoviePages.addAll(getMoviesBetweenDates(release_date_from,release_date_to,i));
				i++;
				if (i % 4 == 0) { // i is an exact multiple of 4
					Thread.sleep(1200);
				}
			}
			catch(RestClientException rcException){
				logger.info("rc-exception");
			}
		}
		return allMoviePages;
	}
	
	public ArrayList<AbstractTvInfoWrapper> getAllTvShowsPagesBetweenDates(String release_date_from, String release_date_to) throws RestClientException, URISyntaxException, InterruptedException {
		HashMap<String, String> variables = new HashMap<String, String>();
		variables.put("first_air_date.gte", release_date_from);
		variables.put("first_air_date.lte", release_date_to);
		variables.put("page","1");
		
		URL url = new MovieApiUrl().buildTvUrl(variables);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<AbstractTvResultsWrapper> response = restTemplate.getForEntity(
				url.toURI(), AbstractTvResultsWrapper.class);

		
		int totalPages = response.getBody().getTotalPages();
		logger.info("total tvshow pages: " + totalPages);
		ArrayList<AbstractTvInfoWrapper> allTvShowPages = new ArrayList();

		int i = 1;
		while(i <= totalPages){
			try{
				allTvShowPages.addAll(getTvShowsBetweenDates(release_date_from,release_date_to,i));
				i++;
				if (i % 4 == 0 ) {// i is an exact multiple of 4
					Thread.sleep(1200);
					System.out.println("tvshow i: " + i);
				}
			}
			catch(RestClientException rcException){
				logger.info("rc-exception");
			}
		}
		return allTvShowPages;
	}

	public ArrayList<AbstractMovieInfoWrapper> getMoviesBetweenDates(String release_date_from, String release_date_to, int page) throws RestClientException, URISyntaxException {
		HashMap<String, String> variables = new HashMap<String, String>();
		variables.put("release_date.gte", release_date_from);
		variables.put("release_date.lte", release_date_to);
		variables.put("page", String.valueOf(page));

		URL url = new MovieApiUrl().buildMovieUrl(variables);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AbstractMovieResultsWrapper> response = restTemplate.getForEntity(
				url.toURI(), AbstractMovieResultsWrapper.class);
		ArrayList<AbstractMovieInfoWrapper> movies = response.getBody().getResults();

//		List<String> a1 = response.getHeaders().get("X-RateLimit-Limit");
//		List<String> a2 = response.getHeaders().get("X-RateLimit-Remaining");
//		List<String> a3 = response.getHeaders().get("X-RateLimit-Reset");
//		System.out.println("X-RateLimit-Remaining" + a2.get(0));
//		System.out.println("X-RateLimit-Reset" + a3.get(0));

		return movies;
	}

	public ArrayList<AbstractTvInfoWrapper> getTvShowsBetweenDates(String release_date_from, String release_date_to, Integer page) throws RestClientException, URISyntaxException {
		HashMap<String, String> variables = new HashMap<String, String>();
		variables.put("first_air_date.gte", release_date_from);
		variables.put("first_air_date.lte", release_date_to);
		variables.put("page", page.toString());

		URL url = new MovieApiUrl().buildTvUrl(variables);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AbstractTvResultsWrapper> response = restTemplate.getForEntity(
				url.toURI(), AbstractTvResultsWrapper.class);
		ArrayList<AbstractTvInfoWrapper> tvShows = response.getBody().getResults();
		return tvShows;
	}
	
	public ArrayList<CreditsInfoWrapper> getTvShowCredits(String tvShowId) throws RestClientException, URISyntaxException {
		URL url = new MovieApiUrl().buildTvCreditsUrl(tvShowId);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<TvCastWrapper> response = restTemplate.getForEntity(
				url.toURI(), TvCastWrapper.class);
		ArrayList<CreditsInfoWrapper> tvShowCredits = response.getBody().getCast();

		return tvShowCredits;
	}
	
	public ArrayList<MovieCreditsInfoWrapper> getMovieCredits(String movieId) throws RestClientException, URISyntaxException {
		URL url = new MovieApiUrl().buildMovieCreditsUrl(movieId);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MovieCastWrapper> response = restTemplate.getForEntity(
				url.toURI(), MovieCastWrapper.class);
		ArrayList<MovieCreditsInfoWrapper> movieCredits = response.getBody().getCast();

		return movieCredits;
	}

}
