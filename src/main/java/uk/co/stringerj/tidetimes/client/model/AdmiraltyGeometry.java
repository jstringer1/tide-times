package uk.co.stringerj.tidetimes.client.model;

public class AdmiraltyGeometry {
  private String type;
  private double[] coordinates;

  public AdmiraltyGeometry() {}

  public AdmiraltyGeometry(String type, double[] coordinates) {
    this.type = type;
    this.coordinates = coordinates;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double[] getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(double[] coordinates) {
    this.coordinates = coordinates;
  }
}
