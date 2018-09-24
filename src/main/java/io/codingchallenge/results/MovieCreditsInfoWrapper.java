package io.codingchallenge.results;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieCreditsInfoWrapper extends CreditsInfoWrapper{
	@JsonProperty("cast_id")
	private int cast_Id = 1;

	public int getCast_Id() {
		return cast_Id;
	}

	public void setCast_Id(int cast_Id) {
		this.cast_Id = cast_Id;
	}

}
