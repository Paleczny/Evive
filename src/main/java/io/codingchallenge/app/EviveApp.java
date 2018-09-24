/**
 * 
 */
package io.codingchallenge.app;


import io.codingchallenge.controller.MovieController;
import io.codingchallenge.results.AbstractMovieInfoWrapper;
import io.codingchallenge.results.AbstractTvInfoWrapper;
import io.codingchallenge.results.CreditsInfoWrapper;
import io.codingchallenge.results.MovieCreditsInfoWrapper;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestClientException;

/**
 * @author Brandon Paleczny
 *
 */
@SpringBootApplication
public class EviveApp {
	private static final Logger logger = LoggerFactory.getLogger(EviveApp.class);	

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(EviveApp.class, args);
        MovieController mvController = new MovieController();
        String fromDate = "2017-12-01";
        String toDate = "2017-12-31";
        logger.info("Start application Evive Coding Challenge");
        logger.info("fromDate- toDate");
        logger.info(fromDate + " - " + toDate);
        Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("ListOfActorsInMovies"), "utf-8"));
        try {
			ArrayList<AbstractMovieInfoWrapper> movies = mvController.getAllMoviesPagesBetweenDates(fromDate, toDate);
			ArrayList<AbstractTvInfoWrapper> tvShows = mvController.getAllTvShowsPagesBetweenDates(fromDate, toDate);
			HashSet<String>movieActorNames = new HashSet();
			HashSet<String>tvShowsActorNames = new HashSet();
			
			int i = 0;
			System.out.println("num of Movies: " + movies.size());
			logger.info("-------List of actors in movies-----");
			for(AbstractMovieInfoWrapper movie : movies){
				if (i % 4 == 0 ) { // i is an exact multiple of 4
					System.out.println("Movie i: " + i);
					Thread.sleep(1200);
				}
				
				ArrayList<MovieCreditsInfoWrapper> movieCreditsCast = mvController.getMovieCredits(String.valueOf(movie.getId()));
				for(MovieCreditsInfoWrapper cast : movieCreditsCast){
					movieActorNames.add(cast.getName());
					writer.write("\n" + cast.getName());
					logger.info("actor " + cast.getName() + " is in the movie " + movie.getOriginalTitle());
				}
			i++;
			}
			
			writer.close();
			i = 0;
			System.out.println("num of tv shows: " + tvShows.size());
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("ListOfActorsInTVShows"), "utf-8"));
			logger.info("-------List of actors in TV Shows-----");
			for(AbstractTvInfoWrapper tvShow : tvShows){
				if (i % 4 == 0 ) {
					System.out.println("tvShow i: " + i);// i is an exact multiple of 4
					Thread.sleep(1200);
				}
				
				ArrayList<CreditsInfoWrapper> tvShowCreditsCast = mvController.getTvShowCredits(String.valueOf(tvShow.getId()));
				for(CreditsInfoWrapper cast : tvShowCreditsCast){
					tvShowsActorNames.add(cast.getName());
					writer.write("\n" + cast.getName());
					logger.info("actor " + cast.getName() + " is in the TV show " + tvShow.getName());
				}
			i++;
			}
			writer.close();
			ArrayList<String> duplicates = new ArrayList<String>(movieActorNames);
			duplicates.retainAll(tvShowsActorNames);
			
			logger.info(duplicates.size() + " Actors in both movies and TV shows between " + fromDate +  " & " + toDate);
			for(String actorName:duplicates){
//				System.out.println("actorName: " + actorName);
				logger.info("actorName: " + actorName);
			}
			
			
			ctx.close();

		} catch (RestClientException e) {
			logger.info("rc-exception");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
	


}
