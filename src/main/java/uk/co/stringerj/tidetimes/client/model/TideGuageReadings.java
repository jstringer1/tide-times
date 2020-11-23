package uk.co.stringerj.tidetimes.client.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TideGuageReadings {

  @JsonProperty("items")
  private List<TideGuageReading> items;

  public List<TideGuageReading> getItems() {
    return items;
  }

  public void setItems(List<TideGuageReading> items) {
    this.items = items;
  }


}
