package com.example.jakub.zadanie4;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jakub on 28.07.2016.
 */
public class PersonServiceResponse {

    @SerializedName("results")
    private List<Result> results;


    public PersonServiceResponse() {}

    public List<Result> getResults() {
        return results;
    }

    public void setResults(final List<Result> result) {
        this.results = result;
    }

}
