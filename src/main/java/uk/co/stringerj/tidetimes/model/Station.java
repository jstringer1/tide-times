package uk.co.stringerj.tidetimes.model;

public class Station {
  private final String admiraltyId;
  private final String tideGuageId;
  private final String name;

  public Station(String admiraltyId, String tideGuageId, String name) {
    this.admiraltyId = admiraltyId;
    this.tideGuageId = tideGuageId;
    this.name = name;
  }

  public String getAdmiraltyId() {
    return admiraltyId;
  }

  public String getTideGuageId() {
    return tideGuageId;
  }

  public String getName() {
    return name;
  }
}
