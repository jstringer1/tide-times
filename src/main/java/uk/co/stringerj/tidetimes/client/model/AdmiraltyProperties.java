package uk.co.stringerj.tidetimes.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdmiraltyProperties {

  @JsonProperty("Id")
  private String id;

  @JsonProperty("Name")
  private String name;

  @JsonProperty("Country")
  private String country;

  @JsonProperty("ContinuousHeightsAvailable")
  private boolean continuousHeightsAvailable;

  @JsonProperty("Footnote")
  private String footnote;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public boolean isContinuousHeightsAvailable() {
    return continuousHeightsAvailable;
  }

  public void setContinuousHeightsAvailable(boolean continuousHeightsAvailable) {
    this.continuousHeightsAvailable = continuousHeightsAvailable;
  }

  public String getFootnote() {
    return footnote;
  }

  public void setFootnote(String footnote) {
    this.footnote = footnote;
  }


}
