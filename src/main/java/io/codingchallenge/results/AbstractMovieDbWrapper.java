package io.codingchallenge.results;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbstractMovieDbWrapper {
	/**
	 * Common variables:
	 * 
	 * id vote_count vote_average popularity poster_path genre_ids
	 * original_language backdrop_path overview
	 */

	@JsonProperty("id")
	private int id = 0;
	@JsonProperty("vote_count")
	private int voteCount = 0;
	@JsonProperty("vote_average")
	private double voteAverage = 0.0;
	@JsonProperty("popularity")
	private double popularity = 0.0;
	@JsonProperty("poster_path")
	private String posterPath = "";
	@JsonProperty("original_language")
	private String originalLanguage = "";
	@JsonProperty("genre_ids")
	private ArrayList<Integer> genreIds = new ArrayList();
	@JsonProperty("backdrop_path")
	private String backdropPath = "";
	@JsonProperty("overview")
	private String overview = "";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public double getPopularity() {
		return popularity;
	}

	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public ArrayList<Integer> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(ArrayList<Integer> genreIds) {
		this.genreIds = genreIds;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}



}
