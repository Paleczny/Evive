package io.codingchallenge.results;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbstractMovieResultsWrapper extends IdPageWrapper {
    @JsonProperty("results")
    private ArrayList<AbstractMovieInfoWrapper> results;

    public ArrayList<AbstractMovieInfoWrapper> getResults() {
		return results;
	}

	public void setResults(ArrayList<AbstractMovieInfoWrapper> results) {
		this.results = results;
	}
}
