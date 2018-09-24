package io.codingchallenge.results;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class IdPageWrapper {
	@JsonProperty("page")
	private int page = 0;

	@JsonProperty("total_results")
	private int totalResults = 0;

	@JsonProperty("total_pages")
	private int totalPages = 0;

	public int getPage() {
		return page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
}
