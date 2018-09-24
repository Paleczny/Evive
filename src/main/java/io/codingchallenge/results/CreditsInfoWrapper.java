package io.codingchallenge.results;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditsInfoWrapper {
	@JsonProperty("character")
	private String character = "";
	@JsonProperty("credit_id")
	private String creditId = "";
	@JsonProperty("gender")
	private int gender = 1;
	@JsonProperty("name")
	private String name = "";
	@JsonProperty("id")
	private String id = "";
	@JsonProperty("order")
	private int order = 1;
	@JsonProperty("profile_path")
	private String profilePath = "";
	
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public String getCreditId() {
		return creditId;
	}
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

}
