package uk.co.stringerj.tidetimes.client.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TideGuageStation {

  @JsonProperty("stationReference")
  private String id;
  @JsonProperty("label")
  private String name;
  @JsonProperty("measures")
  private List<TideGuageMeasure> measures;

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

  public List<TideGuageMeasure> getMeasures() {
    return measures;
  }

  public void setMeasures(List<TideGuageMeasure> measures) {
    this.measures = measures;
  }

}
