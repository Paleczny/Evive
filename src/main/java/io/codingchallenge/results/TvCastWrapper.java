package io.codingchallenge.results;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TvCastWrapper extends CreditsWrapper {
	@JsonProperty("cast")
	private ArrayList<CreditsInfoWrapper> cast;

	public ArrayList<CreditsInfoWrapper> getCast() {
		return cast;
	}

	public void setCast(ArrayList<CreditsInfoWrapper> cast) {
		this.cast = cast;
	}

}
