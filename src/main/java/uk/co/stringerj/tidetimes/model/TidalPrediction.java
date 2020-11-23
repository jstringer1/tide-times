package uk.co.stringerj.tidetimes.model;

import java.util.Date;

public class TidalPrediction {

  private final Type type;
  private final Date dateTime;
  private final double height;

  public TidalPrediction(Type type, Date dateTime, double height) {
    this.type = type;
    this.dateTime = dateTime;
    this.height = height;
  }

  public Type getType() {
    return type;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public double getHeight() {
    return height;
  }

  public enum Type {
    HIGH("HighWater"), LOW("LowWater");

    private final String admiraltyType;

    private Type(String admiraltyType) {
      this.admiraltyType = admiraltyType;
    }

    public static Type byAdmiraltyType(String type) {
      for (Type t : values()) {
        if (t.admiraltyType.equalsIgnoreCase(type)) {
          return t;
        }
      }
      throw new IllegalArgumentException();
    }
  }
}
