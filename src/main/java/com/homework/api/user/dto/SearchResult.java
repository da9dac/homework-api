package com.homework.api.user.dto;

import java.util.List;

import com.homework.api.user.model.TestDa9dac;

public class SearchResult {

	private List<?> searchResponse;
	private List<GroupByResponse> groupByResponse;

	public SearchResult() {
	}

	public SearchResult(List<TestDa9dac> searchResponse, List<GroupByResponse> groupByResponse) {
		this.searchResponse = searchResponse;
		this.groupByResponse = groupByResponse;
	}

	public List<?> getSearchResponse() {
		return searchResponse;
	}

	public List<GroupByResponse> getGroupByResponse() {
		return groupByResponse;
	}
}
