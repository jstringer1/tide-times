package uk.co.stringerj.tidetimes.client.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TideGuageStations {
  @JsonProperty("items")
  private List<TideGuageStation> stations;

  public List<TideGuageStation> getStations() {
    return stations;
  }

  public void setStations(List<TideGuageStation> stations) {
    this.stations = stations;
  }

}
