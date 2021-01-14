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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((admiraltyId == null) ? 0 : admiraltyId.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((tideGuageId == null) ? 0 : tideGuageId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Station other = (Station) obj;
    if (admiraltyId == null) {
      if (other.admiraltyId != null) return false;
    } else if (!admiraltyId.equals(other.admiraltyId)) return false;
    if (name == null) {
      if (other.name != null) return false;
    } else if (!name.equals(other.name)) return false;
    if (tideGuageId == null) {
      if (other.tideGuageId != null) return false;
    } else if (!tideGuageId.equals(other.tideGuageId)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "Station [admiraltyId="
        + admiraltyId
        + ", tideGuageId="
        + tideGuageId
        + ", name="
        + name
        + "]";
  }
}
