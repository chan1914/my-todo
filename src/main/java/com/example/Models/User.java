package com.example.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private int id;
    private String group;
    private String analysisEntries;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAnalysisEntries() {
        return analysisEntries;
    }

    public void setAnalysisEntries(String analysisEntries) {
        this.analysisEntries = analysisEntries;
    }

    public User(@JsonProperty("id") int id, @JsonProperty("group") String group, @JsonProperty("analysisEntries") String analysisEntries) {
        this.id = id;
        this.analysisEntries = analysisEntries;
        this.group = group;
    }


}
