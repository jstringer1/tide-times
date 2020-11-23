package uk.co.stringerj.tidetimes.client.model;

public class AdmiraltyFeature {

  private String type;
  private AdmiraltyGeometry geometry;
  private AdmiraltyProperties properties;

  public String getId() {
    return properties.getId();
  }

  public String getName() {
    return properties.getName();
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AdmiraltyGeometry getGeometry() {
    return geometry;
  }

  public void setGeometry(AdmiraltyGeometry geometry) {
    this.geometry = geometry;
  }

  public AdmiraltyProperties getProperties() {
    return properties;
  }

  public void setProperties(AdmiraltyProperties properties) {
    this.properties = properties;
  }


}
