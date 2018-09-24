package io.codingchallenge.results;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class CreditsWrapper {
//	@JsonProperty("crew")
//	private ArrayList<String> crews = new ArrayList();
	@JsonProperty("id")
	private int id = 0;
	
//	public ArrayList<String> getCrews() {
//		return crews;
//	}
//	public void setCrews(ArrayList<String> crews) {
//		this.crews = crews;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
}
   /**"cast": [
                         {
                             "character": "Jimmy McGill",
                             "credit_id": "534036420e0a2679ad00036d",
                             "id": 59410,
                             "name": "Bob Odenkirk",
                             "gender": 2,
                             "profile_path": "/nJLcRRqq9JTQTgVYrFn7vPDgAsK.jpg",
                             "order": 0}
**/