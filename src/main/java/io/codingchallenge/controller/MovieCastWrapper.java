package io.codingchallenge.controller;

import io.codingchallenge.results.MovieCreditsInfoWrapper;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieCastWrapper {
	@JsonProperty("cast")
	private ArrayList<MovieCreditsInfoWrapper> cast;

	public ArrayList<MovieCreditsInfoWrapper> getCast() {
		return cast;
	}

	public void setCast(ArrayList<MovieCreditsInfoWrapper> cast) {
		this.cast = cast;
	}
}
