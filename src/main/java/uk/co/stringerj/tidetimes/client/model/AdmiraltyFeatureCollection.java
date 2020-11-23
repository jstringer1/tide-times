package uk.co.stringerj.tidetimes.client.model;

import java.util.List;

public class AdmiraltyFeatureCollection {

  private String type;
  private List<AdmiraltyFeature> features;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<AdmiraltyFeature> getFeatures() {
    return features;
  }

  public void setFeatures(List<AdmiraltyFeature> features) {
    this.features = features;
  }



}
