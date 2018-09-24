package io.codingchallenge.results;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbstractTvResultsWrapper extends IdPageWrapper {
	@JsonProperty("results")
	private ArrayList<AbstractTvInfoWrapper> results;

	public ArrayList<AbstractTvInfoWrapper> getResults() {
		return results;
	}

	public void setResults(ArrayList<AbstractTvInfoWrapper> results) {
		this.results = results;
	}
}
